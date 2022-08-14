package aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author rhx
 * @date 2022/7/27 17:33
 **/
@EnableAspectJAutoProxy
@Configuration
public class AspectTest {

	@Bean
	public AspectA aspectA() {
		return new AspectA();
	}

//	@Bean
	public AspectB aspectB() {
		return new AspectB();
	}

	@Bean
	public Service service() {
		return new Service();
	}

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectTest.class);
		final Service service = context.getBean(Service.class);
		service.test();
		service.test1();
	}
}
