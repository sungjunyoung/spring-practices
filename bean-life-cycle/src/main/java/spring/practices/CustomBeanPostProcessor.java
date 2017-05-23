package spring.practices;

/**
 * Created by junyoung on 2017. 5. 23..
 */

import org.springframework.beans.factory.config.*;

public class CustomBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName){
		System.out.println("5. 초기화 전 Bean에 대한 처리 실행");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName){
		System.out.println("8. 초기화 후 Bean에 대한 처리 실행");
		return bean;
	}

}
