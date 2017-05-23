package spring.practices;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class MessageBeanKo implements MessageBean{
	public void sayHello(String name){
		System.out.println("안녕하세요, " + name + " !");
	}
}
