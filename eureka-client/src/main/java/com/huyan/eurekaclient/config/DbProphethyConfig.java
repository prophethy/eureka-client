package com.huyan.eurekaclient.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author by hu_yan on 8/23/2018.
 */
@Configuration
@MapperScan(basePackages = {"com.huyan.eurekaclient.mapper"},
        sqlSessionFactoryRef = "eurekaclientSqlSessionFactory")
@ConfigurationProperties(prefix = "com.huyan.datasource.eurekaclient")
public class DbProphethyConfig extends DruidDataSource {

    public DataSource getDataSource() {
        this.setDriverClassName("com.mysql.jdbc.Driver");
        this.setTestWhileIdle(true);
        this.setRemoveAbandoned(true);
        this.setRemoveAbandonedTimeoutMillis(10000L);
        this.setTimeBetweenEvictionRunsMillis(360000L);
        this.setMinEvictableIdleTimeMillis(360000L);
        return this;
    }

    @Primary
    @Bean
    public DataSource getEurekaClientDataSource() {
        return getDataSource();
    }

    @Primary
    @Bean("eurekaclientSqlSessionFactory")
    public SqlSessionFactoryBean sessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getEurekaClientDataSource());
        Resource resource = new ClassPathResource("mybatis-config.xml");
        factoryBean.setConfigLocation(resource);
        return factoryBean;
    }
}
