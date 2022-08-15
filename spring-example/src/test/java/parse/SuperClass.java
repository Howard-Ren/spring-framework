package parse;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author rhx
 * @date 2022/8/11 18:16
 **/
@Configuration
@Conditional({MyCondition.class})
public class SuperClass {

}
