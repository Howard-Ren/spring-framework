package transactionevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author rhx
 * @date 2022/7/20 17:52
 **/
@EnableTransactionManagement
@Configuration
public class Test {

	@Bean
	public Service service() {
		return new Service(service2());
	}

	@Bean
	public Service2 service2() {
		return new Service2();
	}

	@Bean
	public TransactionManager transactionManager() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
//				.addScript("schema.sql")
//				.addScripts("user_data.sql", "country_data.sql")
				.build();
		return new JdbcTransactionManager(db);
	}

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
		final Service service = context.getBean(Service.class);
//		service.test();
		service.testTimeout();
	}
}
