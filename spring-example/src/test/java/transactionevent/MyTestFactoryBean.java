package transactionevent;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class MyTestFactoryBean implements FactoryBean<MyEvent> {


	@Override
	public MyEvent getObject() throws Exception {
		return new MyEvent(this);
	}

	@Override
	public Class<?> getObjectType() {
		return MyEvent.class;
	}
}
