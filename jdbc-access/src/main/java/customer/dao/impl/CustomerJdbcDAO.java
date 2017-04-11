package customer.dao.impl;

import customer.dao.CustomerDAO;
import customer.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by junyoung on 2017. 4. 11..
 */
public class CustomerJdbcDAO implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " +
						"(CUSTOMER_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
				;
			}
		}
	}

	public Customer findByCustomerId(int customerId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
		Connection conn = null;

		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);

			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				customer = new Customer(
								rs.getInt("CUSTOMER_ID"),
								rs.getString("NAME"),
								rs.getInt("AGE")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			if(conn != null){
				try{
					conn.close();
				} catch(SQLException e){};
			}
		}
	}
}
