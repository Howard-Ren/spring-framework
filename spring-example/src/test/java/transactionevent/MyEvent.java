package transactionevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author rhx
 * @date 2022/7/20 17:54
 **/
public class MyEvent extends ApplicationEvent {

	public MyEvent(Object source) {
		super(source);
	}
}
