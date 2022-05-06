package importt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(SimpleConfiguration.class)
public class ImportExample {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportExample.class);
		SimpleConfiguration bean = context.getBean(SimpleConfiguration.class);
	}
}
