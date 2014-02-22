package com.rebayroo.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("test")
 public class VendorFactoryTest {

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
