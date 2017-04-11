package customer.dao;
import customer.model.Customer;

/**
 * Created by junyoung on 2017. 4. 11..
 */
public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int customerId);
}
