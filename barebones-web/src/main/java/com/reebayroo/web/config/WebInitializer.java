package com.reebayroo.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
		final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		// Normal Spring Bean Context - Bean, Services, DAO's, etc.

		final ContextLoaderListener loaderListener = new ContextLoaderListener(rootContext);
		servletContext.addListener(loaderListener);

//		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();

		// Spring Web Context, Controllers, and such.
		rootContext.register(ApplicationWebContext.class);

		final DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
		final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

}
