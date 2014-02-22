package com.reebayroo.persistence.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("local")
public class VendorFactoryLocal {

	Logger logger = LoggerFactory.getLogger( this.getClass());

	@Bean
	public JpaVendorAdapter vendorAdapter() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				setShowSql(true);
				setGenerateDdl(false);
				setDatabase(Database.MYSQL);
			}
		};
		return vendorAdapter;
	};
}
