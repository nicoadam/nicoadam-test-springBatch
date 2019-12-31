package com.mock.newtech;

import com.mock.newtech.service.MockDataService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NewtechApplicationTests {

	@Autowired
	MockDataService mockDataService;

	@Autowired
	private JobLauncher jobLauncher;

	@Test
	void mockDataServicesTest() throws Exception {
		 JobExecution jobExecution = getJobLauncherTestUtils(this.mockDataService.job())
				.launchJob();
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}


	public JobLauncherTestUtils getJobLauncherTestUtils(Job job) {
		JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
		jobLauncherTestUtils.setJob(job);
		jobLauncherTestUtils.setJobLauncher(this.jobLauncher);
		return jobLauncherTestUtils;
	}

}
