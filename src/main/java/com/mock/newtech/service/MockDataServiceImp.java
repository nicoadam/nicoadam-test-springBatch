package com.mock.newtech.service;

import com.mock.newtech.domain.MockData;
import com.mock.newtech.reader.Reader;
import com.mock.newtech.writer.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockDataServiceImp implements MockDataService {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Reader reader;

    @Autowired
    private Writer writer;

    public MockDataServiceImp(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, Reader reader, Writer writer) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public Job job() throws Exception {
        return jobBuilderFactory.get("mockJob")
                .incrementer(new RunIdIncrementer())
                .start(mockStep())
                .build();
    }


    private Step mockStep() throws Exception {
        return stepBuilderFactory.get("mockStep").<List<MockData>, List<MockData>>chunk(1)
                .reader(this.reader).writer(this.writer)
                .build();
    }


}
