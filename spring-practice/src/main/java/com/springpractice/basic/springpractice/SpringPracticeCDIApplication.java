package com.springpractice.basic.springpractice;

import com.springpractice.basic.springpractice.cdi.SomeCDIBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.springpractice.basic.springpractice.cdi")
public class SpringPracticeCDIApplication {
private static Logger LOGGER2 = LoggerFactory.getLogger(SpringPracticeCDIApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringPracticeCDIApplication.class);

		SomeCDIBusiness cdiBusiness = applicationContext.getBean(SomeCDIBusiness.class);

		LOGGER2.info("{}", cdiBusiness, "This is the logger");

	}

}
