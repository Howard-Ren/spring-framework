package configuration.importtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author rhx
 * @date 2022/8/15 11:51
 **/
@Configuration
@Import(ImportTest.class)
public class ImportTest {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportTest.class);

	}
}
