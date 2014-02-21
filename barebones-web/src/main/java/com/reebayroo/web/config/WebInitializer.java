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
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		// Normal Spring Bean Context - Bean, Services, DAO's, etc.
//		rootContext.register(ApplicationContext.class);

		ContextLoaderListener loaderListener = new ContextLoaderListener(rootContext);
		servletContext.addListener(loaderListener);

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();

		// Spring Web Context, Controllers, and such.
		dispatcherContext.register(WebMVCApplicationContext.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

}
