package com.example.restiapi.configs;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        String myURLString = "jdbc:h2:mem:testdb";
        String myDriverClass = "org.h2.Driver";
        String myDBUser = "sa";
        String myDBPassword = "";

        return DataSourceBuilder.create()
                .username(myDBUser)
                .password(myDBPassword)
                .url(myURLString)
                .driverClassName(myDriverClass)
                .build();
    }
}
