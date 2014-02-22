package com.rebayroo.persistence.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("test")
public class DatasourceFactoryTest {

	@Bean(name = "datasource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource() {
			{
				setDriverClassName("org.hsqldb.jdbcDriver");
				setUrl("jdbc:hsqldb:mem:barebones_db");
				setUsername("sa");
				setPassword("");
			}
		};
		return dataSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JpaVendorAdapter vendorAdapter() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				setShowSql(true);
				setGenerateDdl(true);
				setDatabase(Database.HSQL);
			}
		};
		return vendorAdapter;
	};
}
