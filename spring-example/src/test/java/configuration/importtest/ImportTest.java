package configuration.importtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @author rhx
 * @date 2022/8/15 11:51
 **/
@Configuration
//@Import(ImportTest.class)
public class ImportTest {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportTest.class);
		ImportTest bean = context.getBean(ImportTest.class);
		System.out.println(Arrays.toString(bean.getClass().getInterfaces()));

	}
}
