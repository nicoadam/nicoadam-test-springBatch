package com.mock.newtech.service;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateDBMockDataImp implements CreatedDBMockData{

    private Logger logger = Logger.getLogger(CreateDBMockDataImp.class);

    private JdbcTemplate jdbcTemplate;

    public CreateDBMockDataImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTable() {
        try {
               StringBuilder sb=new StringBuilder("CREATE TABLE mock_data ");
               sb.append("(id integer, first_name varchar(50), last_name varchar(50), email varchar(100), gender varchar(10), ip_address varchar(25))")
               ;
               this.jdbcTemplate.execute(sb.toString());
               logger.info("-----Table created----");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
