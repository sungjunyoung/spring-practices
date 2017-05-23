package spring.practices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiApplication {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}
