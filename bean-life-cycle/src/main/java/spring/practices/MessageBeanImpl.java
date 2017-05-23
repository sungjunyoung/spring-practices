package spring.practices;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware {

	private String greeting;
	private String name;
	private String beanName;
	private BeanFactory beanFactory;

	public MessageBeanImpl(){
		System.out.println("1. Bean 의 생성자 실행");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4. BeanFactory 지정");
		this.beanFactory = beanFactory;
		System.out.println(" -> " + beanFactory.getClass());
	}

	public void setBeanName(String beanName) {
		System.out.println("3. Bean 이름 지정");
		this.beanName = beanName;
		System.out.println(" -> " + beanName);
	}

	public void init(){
		System.out.println("7. 초기화 메서드 실행");
	}

	public void destroy(){
		System.out.println("종료");
	}

	public void afterPropertiesSet(){
		System.out.println("6. 프로퍼티 지정 완료");
	}

	public void sayHello(){
		System.out.println(greeting + beanName + " ! ");
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. 설정 메서드 실행");
	}
}
