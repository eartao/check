package com.example.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.read"}, sqlSessionFactoryRef = "sqlSessionFactory1",sqlSessionTemplateRef  = "sqlSessionTemplate1")
public class MybatisDbAConfig {
    @Autowired
    @Qualifier("readDB")
    private DataSource readDB;


    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(readDB);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/read/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
        return template;
    }
}
