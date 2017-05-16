
import org.junit.Before;
import org.junit.Test;

/**
 * Created by junyoung on 2017. 5. 16..
 */
public class CountTest {
	private int count = 0;
	@Before
	public void setUp(){
		System.out.print(count++);
	}

	@Test
	public void testPlus(){
		System.out.print(count++);
	}

	@Test
	public void increase(){
		System.out.print(count++);
	}
}
