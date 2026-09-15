package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.util.SpringContextUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.context.support.StaticMessageSource;

import java.lang.reflect.Field;
import java.util.Locale;

/** 验证旧状态名称不会阻止作业详情按当前语言展示。 */
public class AutoexecJobStatusLocaleTest {
    /** 同一作业带旧中文名称时可切换语言，未知状态仍保留调用方文案。 */
    @Test
    public void shouldTranslateKnownStatusEvenWithExistingName() throws Exception {
        Field contextField = SpringContextUtil.class.getDeclaredField("ctx");
        contextField.setAccessible(true);
        Object originalContext = contextField.get(null);
        Locale originalLocale = Locale.getDefault();
        try {
            StaticMessageSource source = new StaticMessageSource();
            source.addMessage("term.autoexec.jobstatus.failed", Locale.ENGLISH, "Failed");
            source.addMessage("term.autoexec.jobstatus.failed", Locale.CHINESE, "已失败");
            source.addMessage("term.autoexec.jobstatus.running", Locale.ENGLISH, "Running");
            StaticApplicationContext context = new StaticApplicationContext();
            context.getBeanFactory().registerSingleton("messageSourceAccessor", new MessageSourceAccessor(source));
            new SpringContextUtil().setApplicationContext(context);
            AutoexecJobVo job = new AutoexecJobVo();
            job.setStatus("failed");
            job.setStatusName("已失败");
            Locale.setDefault(Locale.ENGLISH);
            Assert.assertEquals("Failed", job.getStatusName());
            Locale.setDefault(Locale.CHINESE);
            Assert.assertEquals("已失败", job.getStatusName());
            Locale.setDefault(Locale.ENGLISH);
            job.setStatus("running");
            Assert.assertEquals("Running", job.getStatusName());
            job.setStatus("custom");
            job.setStatusName("Custom State");
            Assert.assertEquals("Custom State", job.getStatusName());
            job.setStatus(null);
            Assert.assertEquals("Custom State", job.getStatusName());
        } finally {
            contextField.set(null, originalContext);
            Locale.setDefault(originalLocale);
        }
    }
}
