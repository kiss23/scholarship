package com.jxufe.scholarship.Config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
@MapperScan("com.jxufe.scholarship.dao")
public class DataSourceConfiguration {
    @Value("${jdbcDeiver}")
    private String jdbcDriver;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbcUserName}")
    private String jdbcUserName;
    @Value("${jdbcPassword}")
    private String jdbcPassword;
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        //关闭后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
