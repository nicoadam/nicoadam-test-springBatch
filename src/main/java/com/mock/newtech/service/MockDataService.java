package com.mock.newtech.service;

import org.springframework.batch.core.Job;

public interface MockDataService {

    Job job() throws Exception;
}
