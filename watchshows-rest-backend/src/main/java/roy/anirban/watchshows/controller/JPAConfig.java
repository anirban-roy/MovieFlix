package roy.anirban.watchshows.controller;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emFact = new LocalContainerEntityManagerFactoryBean();
		emFact.setDataSource(getDataSource());
		emFact.setPackagesToScan("roy.anirban.watchshows.entities");
		emFact.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emFact.setJpaProperties(getJpaProperties());		
		return emFact;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/movies_and_series?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emb){
		JpaTransactionManager jpmanager = new JpaTransactionManager(emb);
		return jpmanager;
	}
	
	public Properties getJpaProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		//properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		return properties;
	}
}
