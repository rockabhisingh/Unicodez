package com.customers.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class CustomersConfig {


	@Value("${spring.datasource.driver-class-name}") 
    private String DRIVER; 
 
    @Value("${spring.datasource.password}")
    private String PASSWORD;
  
    @Value("${spring.datasource.url}")
    private String foURL;
 
    @Value("${spring.datasource.username}")
    private String USERNAME;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
    private String DIALECT;
 
   
 
    @Value("${entitymanager.packagesToScan}")
    private String PACKAGES_TO_SCAN;

    @Bean(name="customerDataSource")
   	public DataSource customerDataSource() {
   		DriverManagerDataSource dataSource = new DriverManagerDataSource();
   		dataSource.setDriverClassName(DRIVER);
   		dataSource.setUrl(foURL);
   		dataSource.setUsername(USERNAME);
   		dataSource.setPassword(PASSWORD);
   		return dataSource;
   	}
       
   @Bean(name="customerPortalSessionFactory")
   public LocalSessionFactoryBean customerPortalSessionFactory() {
       
   	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       
       sessionFactory.setDataSource(customerDataSource());
       sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
       
       Properties hibernateProperties = new Properties();
       hibernateProperties.put("hibernate.dialect",DIALECT);
       hibernateProperties.put("hibernate.show_sql", true);
    
       sessionFactory.setHibernateProperties(hibernateProperties);
       return sessionFactory;
   
   
   }
       
   @Bean(name="customerTransactionManger")
   public HibernateTransactionManager xotikPortalTransactionManager() {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(customerPortalSessionFactory().getObject());
       return txManager;
   }

}
