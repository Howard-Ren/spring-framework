package aspect.dynamic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class PointcutTest {

	@Bean
	public MyAspect myAspect(){
		return new MyAspect();
	}

	public void test(ParameterInterface pi) {
		System.out.println("test");
	}

	public void test2(ParameterClass pi) {
		System.out.println("test2");
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PointcutTest.class);
		PointcutTest test = context.getBean(PointcutTest.class);
		ParameterClass pc = new ParameterClass();
		test.test(pc);
		test.test2(pc);
	}
}
