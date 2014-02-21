package com.reebayroo.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.reebayroo.service.config.ApplicationServiceContext;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		// Normal Spring Bean Context - Bean, Services, DAO's, etc.

		ContextLoaderListener loaderListener = new ContextLoaderListener(rootContext);
		servletContext.addListener(loaderListener);

//		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();

		// Spring Web Context, Controllers, and such.
		rootContext.register(ApplicationWebContext.class);
		rootContext.register(ApplicationServiceContext.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

}
