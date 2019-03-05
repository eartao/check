package com.example.demo;

import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.tomcat.jdbc.pool.DataSource;
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
@Configuration
//@MapperScan("com.example.demo.mapper.write")
@MapperScan(basePackages = {"com.example.demo.mapper.write"}, sqlSessionFactoryRef = "sqlSessionFactory2",sqlSessionTemplateRef  = "sqlSessionTemplate2")
public class MybatisDbAConfig1 {
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource.write")
//    public org.apache.tomcat.jdbc.pool.DataSource dataSource() {
//        return new DataSource();
//    }
//
//    //提供SqlSeesion
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("/mybatis/write/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }


    @Autowired
    @Qualifier("writeDB")
    private DataSource ds2;

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds2);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/write/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
        return template;
    }
}
