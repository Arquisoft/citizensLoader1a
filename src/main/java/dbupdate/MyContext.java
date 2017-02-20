package dbupdate;

import org.springframework.context.ConfigurableApplicationContext;

public class MyContext {

	private static ConfigurableApplicationContext  context;

	public static void setApplicationContext(ConfigurableApplicationContext  applicationContext) {
		context = applicationContext;
	}

	public static ConfigurableApplicationContext  getApplicationContext() {
		return context;
	}
}