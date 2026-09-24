package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.asynchronization.threadlocal.RequestContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/** 验证旧状态名称不会阻止作业详情按当前语言展示。 */
public class AutoexecJobStatusLocaleTest {
    /** 同一作业带旧中文名称时可切换语言，未知状态仍保留调用方文案。 */
    @Test
    public void shouldTranslateKnownStatusEvenWithExistingName() throws Exception {
        RequestContext originalContext = RequestContext.get();
        RequestContext context = RequestContext.init(null);
        try {
            AutoexecJobVo job = new AutoexecJobVo();
            job.setStatus("failed");
            job.setStatusName("已失败");
            context.setLocale(Locale.ENGLISH);
            Assert.assertEquals("Failed", job.getStatusName());
            context.setLocale(Locale.CHINESE);
            Assert.assertEquals("已失败", job.getStatusName());
            context.setLocale(Locale.ENGLISH);
            job.setStatus("running");
            Assert.assertEquals("Running", job.getStatusName());
            job.setStatus("custom");
            job.setStatusName("Custom State");
            Assert.assertEquals("Custom State", job.getStatusName());
            job.setStatus(null);
            Assert.assertEquals("Custom State", job.getStatusName());
        } finally {
            context.release();
            if (originalContext != null) {
                RequestContext.init(originalContext);
            }
        }
    }
}
