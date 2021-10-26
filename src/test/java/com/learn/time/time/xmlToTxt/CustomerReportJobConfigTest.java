package com.learn.time.time.xmlToTxt;

import com.learn.time.time.TimeApplication;
import com.learn.time.time.batch.xmltotxt.configuration.CustomerReportJobConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link CustomerReportJobConfig}.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TimeApplication.class, BatchTestConfiguration.class})
public class CustomerReportJobConfigTest {

    @Autowired
    private JobLauncherTestUtils testUtils;

    @Autowired
    private CustomerReportJobConfig config;

    @Test
    public void testEntireJob() throws Exception {
        final JobExecution result = testUtils.getJobLauncher().run(config.customerReportJob(), testUtils.getUniqueJobParameters());
        Assert.assertNotNull(result);
        Assert.assertEquals(BatchStatus.COMPLETED, result.getStatus());
    }

    @Test
    public void testSpecificStep() {
        Assert.assertEquals(BatchStatus.COMPLETED, testUtils.launchStep(CustomerReportJobConfig.TASKLET_STEP).getStatus());
    }

}