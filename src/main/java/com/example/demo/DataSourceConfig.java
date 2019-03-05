package com.example.demo;

//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = "readDB")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource dataSource1() {
//        return new DataSource();
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "writeDB")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource dataSource2() {
//        return new DataSource();
        return DataSourceBuilder.create().build();
    }
}
