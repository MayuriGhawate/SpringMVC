package com.hospital.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.hospital.config.entities");
		JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("c##orcl");
		ds.setPassword("orcl29");
		return ds;
		
	}
	private Properties jpaProperties(){
		Properties props =new Properties();
		props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		props.setProperty("hibernate.hbm2ddl.auto","validate");
		props.setProperty("hibernate.show_sql","true");
		props.setProperty("hibernate.format_sql","true");
		return props;
	}
	@Bean
    @Autowired
	public JpaTransactionManager jpaTransMan(){
		JpaTransactionManager jtManager = new JpaTransactionManager(
				EntityManagerFactory().getObject());
		return jtManager;
	}
}
