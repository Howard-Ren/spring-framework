package parse;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author rhx
 * @date 2022/8/11 18:23
 **/
public class MyCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		final String test = context.getEnvironment().getProperty("test");
		return "true".equals(test);
	}
}
