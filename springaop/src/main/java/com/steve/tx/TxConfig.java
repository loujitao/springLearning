package com.steve.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description:   数据库连接配置，Spring事务控制注解
 * @Author: SteveTao
 * @Date: 2020/2/1514:46
 *
 *      1) 导入依赖: 数据源c3p0、数据库驱动mysql-connector-java、spring-jdbc模块
 *      2）配置数据源datasource、JdbcTemplate实体bean注入到ioc容器中
 *      3）给业务层service的方法上标注@Transactional， 表示方法是一个事务方法
 *      4）@EnableTransactionManagement  开启基于注解的事务管理功能
 *      5）配置事务管理器，来管理数据源
 **/
@EnableTransactionManagement
@PropertySource("classpath:/jdbc.properties")
@Configuration
@ComponentScan(basePackages = "com.steve.tx")
public class TxConfig {
    @Value("${mysql.user}")
    private String user;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.driverClass}")
    private String driverClass;
    @Value("${mysql.url}")
    private String url;

    //注入数据库连接池
    @Bean
    public DataSource dataSource() throws  Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        //注入容器中的组件，同类中可以直接调用方法，配置文件类做了优化直接从容器中拿
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注入事务管理器，管理数据源
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
