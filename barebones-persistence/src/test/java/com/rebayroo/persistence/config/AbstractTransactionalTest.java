package com.rebayroo.persistence.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.reebayroo.persistence.config.ApplicationPersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { DatasourceFactoryTest.class, //
		VendorFactoryTest.class, ApplicationPersistenceContext.class })
@Transactional
public abstract class AbstractTransactionalTest {

}
