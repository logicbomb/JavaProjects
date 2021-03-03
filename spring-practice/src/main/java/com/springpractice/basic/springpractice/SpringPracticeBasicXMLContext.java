package com.springpractice.basic.springpractice;

import com.springpractice.basic.springpractice.xml.XMLPersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringPracticeBasicXMLContext {

private static Logger LOGGER = LoggerFactory.getLogger(SpringPracticeBasicXMLContext.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

LOGGER.info("Beans loaded ->", (Object) applicationContext.getBeanDefinitionNames());

			XMLPersonDao personDao = applicationContext.getBean(XMLPersonDao.class);



			LOGGER.info("{} {}", personDao, personDao.getXMLJdbcConnection());
				applicationContext.close();


	}

}
