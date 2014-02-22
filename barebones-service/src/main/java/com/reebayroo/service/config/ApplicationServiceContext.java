package com.reebayroo.service.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.reebayroo.persistence.config.ApplicationPersistenceContext;


@Configuration
@ComponentScan(basePackages="com.reebayroo.service.")
@Import(ApplicationPersistenceContext.class)
public class ApplicationServiceContext{

}
