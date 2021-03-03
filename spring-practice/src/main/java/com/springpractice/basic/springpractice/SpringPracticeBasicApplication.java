package com.springpractice.basic.springpractice;

import com.springpractice.basic.springpractice.basic.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class SpringPracticeBasicApplication {
private static Logger LOGGER = LoggerFactory.getLogger(SpringPracticeBasicApplication.class);

	public static void main(String[] args) {
//		Frame frame = new Frame();
//		frame.setSize(300, 300);
//		Panel panel = new Panel();
//		TextField textArea = new TextField();
//		textArea.setBounds(50, 50, 50, 50);
//		textArea.setSize(200, 10);
//		Button clickMe = new Button();
//		clickMe.setLabel("Click Me");
//		clickMe.setSize(50, 20);
//		clickMe.setBounds(10, 10, 50, 50);
//		panel.add(textArea);
//		panel.add(clickMe);
//		frame.add(panel);
//
//
//		frame.setVisible(true);


		//	BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSorAlogrith());
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringPracticeBasicApplication.class);




//		clickMe.addActionListener(new ActionListener() {
////			@Override
//			public void actionPerformed(ActionEvent e) {
				BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);



				int result = binarySearch.binarySearch(new Integer[]{1, 2, 5, 6}, 2);

				System.out.println("The result of the search is " + result);

				applicationContext.close();
//				frame.dispose();
//			}
//		});


	}

}
