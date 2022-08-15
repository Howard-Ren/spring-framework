package parse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author rhx
 * @date 2022/8/11 18:24
 **/
@Configuration
public class MyTest {

	@Test
	public void test1() {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTest.class, SuperClass.class);
		Assertions.assertFalse(context.containsBean("superClass"));
	}

	@Test
	public void test2() {
		System.setProperty("test", "true");
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTest.class, SuperClass.class);
		Assertions.assertTrue(context.containsBean("superClass"));
	}


	@Test
	public void test3() {
		System.setProperty("test", "false");
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTest.class, SuperClass.class, SubClass.class);
		Assertions.assertFalse(context.containsBean("superClass"));
	}

}
