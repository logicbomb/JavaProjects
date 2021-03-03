package com.springpractice.basic.springpractice;

import com.springpractice.basic.springpractice.external.SomeExternalServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.springpractice.basic.springpractice.external")

@PropertySource("classpath:app.properties")
public class SpringPracticeExternalApplication {
private static Logger LOGGER2 = LoggerFactory.getLogger(SpringPracticeExternalApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringPracticeExternalApplication.class);

		SomeExternalServices externalServices = applicationContext.getBean(SomeExternalServices.class);

		LOGGER2.info("{}", externalServices, externalServices.returnServiceURL());
		System.out.println(externalServices.returnServiceURL());

	}

}
