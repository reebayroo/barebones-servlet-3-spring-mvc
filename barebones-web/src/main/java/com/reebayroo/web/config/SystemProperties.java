package com.reebayroo.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
@Service
@PropertySource( "classpath:system-${spring.profiles.active}.properties"  )
public class SystemProperties {
	@Autowired
	@Value("${company.name}")
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Bean(name="systempspc")
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
		propertySourcesPlaceholderConfigurer.setOrder(2);
		return propertySourcesPlaceholderConfigurer;
	}

}
