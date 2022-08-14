package transactionevent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author rhx
 * @date 2022/7/20 17:54
 **/
public class Service implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	private Service2 sevice2;

	@Autowired
	private TransactionManager transactionManager;

	public Service(Service2 service2){
		this.sevice2 = service2;
	}

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT, fallbackExecution = false)
	public void handleEvent1(MyEvent event) {
		System.out.print("before commit\t");
		System.out.println(event);
	}


	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handleEvent2(MyEvent event) {
		System.out.print("after commit\t");
		System.out.println(event);
	}


	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void handleEvent3(MyEvent event) {
		System.out.print("after rollback\t");
		System.out.println(event);
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
	public void handleEvent4(MyEvent event) {
		System.out.print("after completion\t");
		System.out.println(event);
	}

	@Transactional
	public void test() {
		final MyEvent myEvent = new MyEvent(this);
		System.out.println("before event publish");
		applicationContext.publishEvent(myEvent);
		applicationContext.publishEvent(new MyEvent(this));
		System.out.println("after event publish");

	}


	@Transactional(timeout = 1)
	public void testTimeout(){
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JdbcTransactionManager tm = (JdbcTransactionManager) transactionManager;
		try {
			final Connection connection = tm.getDataSource().getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement("select 1");
			preparedStatement.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
