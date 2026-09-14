package neatlogic.framework.autoexec.globallock;

import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.transaction.util.TransactionUtil;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import java.lang.reflect.*;
import java.util.*;
import static org.junit.Assert.*;

/** 验证实际 Mapper 代理切点、事务内去重及最终状态检查时机。 */
public class AutoexecJobGlobalLockLifecycleTest {
    private JdbcTemplate jdbc;
    private AutoexecJobMapper mapper;
    private final List<String> checked = new ArrayList<>();
    @Before public void setup() throws Exception {
        JdbcDataSource source = new JdbcDataSource(); source.setURL("jdbc:h2:mem:"+UUID.randomUUID()+";DB_CLOSE_DELAY=-1");
        jdbc = new JdbcTemplate(source); jdbc.execute("CREATE TABLE job(id BIGINT PRIMARY KEY,status VARCHAR)"); jdbc.update("INSERT INTO job VALUES(1,'running')");
        new TransactionUtil(new DataSourceTransactionManager(source));
        AutoexecJobMapper target=(AutoexecJobMapper)Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{AutoexecJobMapper.class},(proxy,method,args)-> {
            if (method.getName().equals("updateJobStatus")) { AutoexecJobVo vo=(AutoexecJobVo)args[0]; return jdbc.update("UPDATE job SET status=? WHERE id=?",vo.getStatus(),vo.getId()); }
            if (method.getName().equals("toString")) return "testMapper";
            return null;
        });
        AutoexecJobGlobalLockLifecycleAspect aspect=new AutoexecJobGlobalLockLifecycleAspect();
        Field field=aspect.getClass().getDeclaredField("service"); field.setAccessible(true);
        field.set(aspect,new AutoexecJobGlobalLockService(){ @Override public void cleanup(Long id){ checked.add(jdbc.queryForObject("SELECT status FROM job WHERE id=?",String.class,id)); }});
        AspectJProxyFactory proxy=new AspectJProxyFactory(target); proxy.addAspect(aspect); mapper=proxy.getProxy();
    }
    @Test public void checksFinalStateOnceAtOuterCommit() {
        TransactionStatus tx=TransactionUtil.openTx(); mapper.updateJobStatus(new AutoexecJobVo(1L,"completed")); mapper.updateJobStatus(new AutoexecJobVo(1L,"running"));
        assertTrue(checked.isEmpty()); TransactionUtil.commitTx(tx); assertEquals(Collections.singletonList("running"),checked);
    }
    @Test public void rollbackDoesNotRunCleanup() {
        TransactionStatus tx=TransactionUtil.openTx(); mapper.updateJobStatus(new AutoexecJobVo(1L,"failed")); TransactionUtil.rollbackTx(tx);
        assertTrue(checked.isEmpty()); assertEquals("running",jdbc.queryForObject("SELECT status FROM job",String.class));
    }
    @Test public void standaloneUpdateCreatesTransaction() {
        mapper.updateJobStatus(new AutoexecJobVo(1L,"paused")); assertEquals(Collections.singletonList("paused"),checked);
    }
    @Test public void terminalSetIncludesPausedButNotTransitionStates() {
        for(String status:Arrays.asList("completed","checked","failed","aborted","revoked","paused")) assertTrue(AutoexecJobGlobalLockService.isTerminal(status));
        for(String status:Arrays.asList("running","pausing","aborting","waitInput","waiting","pending")) assertFalse(AutoexecJobGlobalLockService.isTerminal(status));
    }
}
