package main.java;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Collections;
import java.util.Map;

/**
 * Created by junyoung on 2017. 5. 16..
 */
public class BookDao {
	private NamedParameterJdbcTemplate jdbc;
	public static final String COUNT_BOOK = "SELECT COUNT(*) FROM book";

	public BookDao(DriverManagerDataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public int countBooks(){
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
	}
}
