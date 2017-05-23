package spring.practices;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class MessageBeanEn implements MessageBean{
	public void sayHello(String name){
		System.out.println("Hello, " + name + " !");
	}
}
