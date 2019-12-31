package com.mock.newtech.schedulers;

import com.mock.newtech.service.MockDataService;
import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MockDataSchedulerImpl {

    private final static Logger logger = Logger.getLogger(MockDataSchedulerImpl.class);
    private MockDataService mockDataService;

    private SimpleJobLauncher simpleJobLauncher;

    public MockDataSchedulerImpl(MockDataService mockDataService, SimpleJobLauncher simpleJobLauncher) {
        this.mockDataService = mockDataService;
        this.simpleJobLauncher = simpleJobLauncher;
    }

    @Scheduled(cron = "${com.mock.intervalExecutionsTime}")
    public void creatorScheduler() {
        try {
            logger.info("Job Started at :"+ new Date());
            logger.info("inserted");
            JobParameters param = new JobParametersBuilder().addString("JobID",
                    String.valueOf(System.currentTimeMillis())).toJobParameters();
            JobExecution execution = simpleJobLauncher.run(this.mockDataService.job(), param);
            logger.info("Job finished with status :" + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
