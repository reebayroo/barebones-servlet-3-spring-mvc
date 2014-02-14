package com.reebayroo.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
 import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

@Configuration
@ComponentScan(basePackages = "com.reebayroo.web")
@EnableWebMvc
public class WebMVCApplicationContext extends WebMvcConfigurerAdapter {

	@Bean(name = "viewResolver")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		return resolver;
	}

	@Bean(name = "tilesViewResolver")
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").setCachePeriod(Integer.MAX_VALUE);
	}

	// @Bean(name = "multipartResolver")
	// public MultipartResolver multipartResolver() {
	// return new CommonsMultipartResolver();
	// }

	@Bean(name = "tilesConfigurer")
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {//
				"/WEB-INF/tiles-defs.xml" //
				});

		return tilesConfigurer;
	}

	@Bean(name = "simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

		// Properties mappings = new Properties();
		// mappings.setProperty("DatabaseException", "databaseError");
		// mappings.setProperty("InvalidCreditCardException",
		// "creditCardError");
		//
		// r.setExceptionMappings(mappings); // None by default
		r.setDefaultErrorView(".error"); // No default
		r.setExceptionAttribute("ex"); // Default is "exception"
		r.setWarnLogCategory("example.MvcLogger"); // No default
		return r;
	}


	@Bean
	HandlerExceptionResolverComposite getHandlerExceptionResolverComposite() {

		HandlerExceptionResolverComposite result = new HandlerExceptionResolverComposite();

		List<HandlerExceptionResolver> l = new ArrayList<HandlerExceptionResolver>();

 		l.add(new ResponseStatusExceptionResolver());
		l.add(createSimpleMappingExceptionResolver());
		l.add(new DefaultHandlerExceptionResolver());

		result.setExceptionResolvers(l);

		return result;

	}
}
