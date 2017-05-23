package spring.practices;

import java.io.IOException;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;

	private Outputter outputter;

	public MessageBeanImpl(String name){
		this.name = name;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println(message);
		try{
			outputter.output(message);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
}
