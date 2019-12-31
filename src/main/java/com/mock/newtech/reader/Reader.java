package com.mock.newtech.reader;

import com.mock.newtech.domain.MockData;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Reader implements ItemReader<List<MockData>> {

    @Override
    public List<MockData> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        FlatFileItemReader<MockData> flatFileItemReader=new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource("input/MOCK_DATA.csv"));
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"id", "first_name", "last_name", "email", "gender", "ip_address"});
                    }
                });

                setFieldSetMapper(new BeanWrapperFieldSetMapper<MockData>() {
                    {
                        setTargetType(MockData.class);
                    }
                });
            }
        });

        flatFileItemReader.open(new ExecutionContext());
        List<MockData> mockDataList=new ArrayList<>();
        MockData mockData = null;
        do {

            mockData = flatFileItemReader.read();
            mockDataList.add(this.validateData(mockData));
        } while (mockData != null);

        return mockDataList;
    }


    private MockData validateData(MockData mockData) {

       /* mockData.setFirst_Name(mockData.getFirst_Name().replaceAll("[^a-zA-Z&&[^\\s]&&[^.,][Ññ]]+", ""));
        mockData.setLast_Name(mockData.getLast_Name().replaceAll("[^a-zA-Z&&[^\\s]&&[^.,][Ññ]]+", ""));
        mockData.setGender(mockData.getGender().replaceAll("[^a-zA-Z&&[^\\s]&&[^.,][Ññ]]+", ""));*/

        return mockData;
    }


}
