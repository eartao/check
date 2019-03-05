package com.example.demo;
import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.log4j.Logger;
        import org.apache.tomcat.jdbc.pool.DataSource;
        import org.mybatis.spring.SqlSessionFactoryBean;
        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Bean;
        import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
        import org.springframework.jdbc.datasource.DataSourceTransactionManager;
        import org.springframework.transaction.PlatformTransactionManager;


//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
//@MapperScan("com.example.demo.mapper")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    //DataSource配置
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return new DataSource();
//    }
//
//    //提供SqlSeesion
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
////        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("com/example/demo/mapper/*.xml"));
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("/mybatis/*.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

}


