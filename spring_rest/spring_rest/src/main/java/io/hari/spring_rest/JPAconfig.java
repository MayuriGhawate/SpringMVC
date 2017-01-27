package io.hari.spring_rest;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAconfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/example-db");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
		
	}
	private Properties jpaProperties(){
		Properties props =new Properties();
		props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto","validate");
		props.setProperty("hibernate.show_sql","true");
		props.setProperty("hibernate.format_sql","true");
		return props;
	}
}
