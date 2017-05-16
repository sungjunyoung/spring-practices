import org.junit.Before;
import org.junit.Test;

public class CountTest{
	private int count = 0;
	@Before
	public void setUp(){
		System.out.println("This is Before : " + count++);
	}

	@Test
	public void testPlus(){
		System.out.println("This is testPlus : " + count++);
	}

	@Test
	public void increase(){
		System.out.println("This is increase : " + count++);
	}
}