package customer.model;

import java.sql.Timestamp;

public class Customer {
	private int customerId;
	private String name;
	private int age;

	public Customer(int customer_id, String name, int age) {
		this.customerId = customer_id;
		this.name = name;
		this.age = age;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}