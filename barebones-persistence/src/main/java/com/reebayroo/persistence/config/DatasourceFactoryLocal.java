package com.reebayroo.persistence.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@Profile("local")
@PropertySource("classpath:datasource-local.properties")
public class DatasourceFactoryLocal {

	@Value("${jdbc.initialSize}")
	@Autowired
	private int dbInitialSize;

	@Value("${jdbc.maxActive}")
	@Autowired
	private int dbMaxActive;

	@Value("${jdbc.maxIdle}")
	@Autowired
	private int dbMaxIdle;

	@Value("${jdbc.maxWait}")
	@Autowired
	private long dbMaxWait;

	@Value("${jdbc.defaultAutoCommit}")
	@Autowired
	private boolean dbDefaultAutoCommit;

	@Value("${jdbc.poolPreparedStatements}")
	@Autowired
	private boolean dbPoolPreparedStatements;

	@Value("${jdbc.driver}")
	@Autowired
	private String dbDriver;

	@Value("${jdbc.url}")
	@Autowired
	private String dbUrl;

	@Value("${jdbc.username}")
	@Autowired
	private String dbUsername;

	@Value("${jdbc.password}")
	@Autowired
	private String dbPassword;


	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	
	@Bean(name = "datasource")
	public DataSource dataSource() {

		logger.info("Creating this datasource {}", this.toString());
		BasicDataSource dataSource = new BasicDataSource() {
			{
				setInitialSize(dbInitialSize);
				setMaxActive(dbMaxActive);
				setMaxIdle(dbMaxIdle);
				setMaxWait(dbMaxWait);
				setDefaultAutoCommit(dbDefaultAutoCommit);
				setPoolPreparedStatements(dbPoolPreparedStatements);
				setDriverClassName(dbDriver);
				setUrl(dbUrl);
				setUsername(dbUsername);
				setPassword(dbPassword);

			}
		};
		return dataSource;
	}

	@Bean(name="datasourcePlaceHolder")
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setOrder(1);
		propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
		return propertySourcesPlaceholderConfigurer;
	}
}
