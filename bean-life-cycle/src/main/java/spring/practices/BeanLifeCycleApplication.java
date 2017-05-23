package spring.practices;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApplication {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		MessageBean bean = (MessageBean)factory.getBean("messageBean");
		bean.sayHello();
	}
}
