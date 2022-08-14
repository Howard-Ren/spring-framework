package configuration;

import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MemberClass {

	@Configuration(proxyBeanMethods = false)
	public class NonStaticClass{

		public MemberClass getOuter(){
			return MemberClass.this;
		}

	}

	@Configuration(proxyBeanMethods = false)
	public static class StaticClass{

	}

}
