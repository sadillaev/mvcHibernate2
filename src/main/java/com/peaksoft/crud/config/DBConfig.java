package com.peaksoft.crud.config;

import com.peaksoft.crud.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = "com.peaksoft.crud")
@EnableTransactionManagement
public class DBConfig {

    @Bean
    public DataSource getDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDatasource());
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
