package com.mock.newtech;

import com.mock.newtech.service.CreatedDBMockData;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.mock.newtech")
@EnableBatchProcessing
@EnableScheduling
public class NewtechApplication implements CommandLineRunner {

	private CreatedDBMockData createdDBMockData;

	public NewtechApplication(CreatedDBMockData createdDBMockData) {
		this.createdDBMockData = createdDBMockData;
	}

	public static void main(String[] args) {
		SpringApplication.run(NewtechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			this.createdDBMockData.createTable();
	}
}
