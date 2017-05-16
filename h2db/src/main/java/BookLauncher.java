package main.java;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by junyoung on 2017. 5. 16..
 */
public class BookLauncher {

	public static void main(String[] ags){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		BookDao dao = new BookDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);
	}
}
