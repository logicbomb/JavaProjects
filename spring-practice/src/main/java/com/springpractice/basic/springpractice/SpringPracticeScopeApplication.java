package com.springpractice.basic.springpractice;

import com.springpractice.basic.springpractice.scope.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class SpringPracticeScopeApplication {
private static Logger LOGGER = LoggerFactory.getLogger(SpringPracticeScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringPracticeScopeApplication.class);

		PersonDao personDao = applicationContext.getBean(PersonDao.class);
		PersonDao personDao2 = applicationContext.getBean(PersonDao.class);

		LOGGER.info("{}", personDao);
		LOGGER.info("{}", personDao.getJdbcConnection());
		LOGGER.info("{}", personDao2);
		LOGGER.info("{}", personDao2.getJdbcConnection());

	}

}
