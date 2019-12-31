package com.mock.newtech.writer;

import com.mock.newtech.domain.MockData;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Writer implements ItemWriter<List<MockData>> {

    private final static Logger logger = Logger.getLogger(Writer.class);

    private JdbcTemplate jdbcTemplate;

    private StringBuilder sb=new StringBuilder();

    public Writer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void write(List<? extends List<MockData>> items) throws Exception {

        this.jdbcTemplate.update(cleanData());

        List<MockData> mockDataList = items.stream().
                flatMap(o -> o.stream())
                .collect(Collectors.toList());

                mockDataList.stream()
                .filter(x -> Optional.ofNullable(x).isPresent())
                .forEach( mock -> {
                     this.jdbcTemplate.update(insertData(mock));
                } );
    }

    private String insertData(MockData mockData) {
        sb.setLength(0);
        sb.append("INSERT INTO mock_data (")
                .append("id,")
                .append("first_name,")
                .append("last_name,")
                .append("email,")
                .append("gender,")
                .append("ip_address) VALUES (")
                .append(mockData.getId()).append(",'")
                .append(mockData.getFirst_Name()).append("','")
                .append(mockData.getLast_Name().replace("'","")).append("','")
                .append(mockData.getEmail()).append("','")
                .append(mockData.getGender()).append("','")
                .append(mockData.getIp_Address()).append("')")
                ;
        return sb.toString();
    }

    private String cleanData() {
        sb.setLength(0);
        sb.append("DELETE FROM mock_data");
        return sb.toString();
    }

}
