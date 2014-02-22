package com.reebayroo.persistence.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@ComponentScan(basePackages="com.reebayroo.service.")
public class ApplicationPersistenceContext{
	@Autowired
	private DataSource datasource;
	@Autowired
	private JpaVendorAdapter vendorAdapter;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(this.datasource);
		factoryBean.setPackagesToScan(new String[] { "com.reebayroo.persistence.domain", //
				"com.reebayroo.persistence.dao" });
		factoryBean.setJpaVendorAdapter(vendorAdapter);

		return factoryBean;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());

		return transactionManager;
	}
}
