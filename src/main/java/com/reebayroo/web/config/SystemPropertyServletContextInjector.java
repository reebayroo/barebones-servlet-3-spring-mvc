package com.reebayroo.web.config;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemPropertyServletContextInjector implements InitializingBean {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	MetadataProperties metadataProperties;
	
	@Autowired
	SystemProperties systemProperties;

	@Autowired
	ServletContext servletContext;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info(" afterPropertiesSet ");
		Validate.notNull(servletContext);
		servletContext.setAttribute("metadataProperties", metadataProperties);
		servletContext.setAttribute("systemProperties", systemProperties);

	}

}
