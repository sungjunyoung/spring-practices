/**
 * Created by junyoung on 2017. 5. 16..
 */

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Properties;
import org.junit.Test;

public class CommanderConfigParseTest {

	@Test
	public void testParse(){
		String[] commandArgs = new String[]{"port=2121", "ssl=true"};
		Properties options = Commander.parseConfigParams(commandArgs);

		assertThat(options.getProperty("port"), is("2121"));
		assertThat(options.getProperty("ssl"), is("true"));
	}
}
