package importt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SimpleConfiguration {

	@Configuration
	public static class InnerStaticClass {
		public InnerStaticClass() {
			System.out.println();
		}
	}

	@Configuration
	public class InnerInstanceClass {
		public InnerInstanceClass() {
			System.out.println("yes");
		}
	}

	@Bean
	public static StaticMethodTest staticMethodTest() {
		return new StaticMethodTest();
	}

	@Bean
	public InstanceMethodTest instanceMethodTest() {
		return new InstanceMethodTest();
	}

}
