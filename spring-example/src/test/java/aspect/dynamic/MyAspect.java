package aspect.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author rhx
 * @date 2022/7/27 17:34
 **/
@Aspect
public class MyAspect {

	@Pointcut("execution(* test*(..))")
	public void pt() {
	}

	@Before("args(aspect.dynamic.ParameterClass)")
	public void advice1() {
		System.out.println("advice1");
	}

	@Before("execution(public void test*(aspect.dynamic.ParameterClass))")
	public void advice2(){
		System.out.println("advice2");
	}

	@Before("execution(public void test*(aspect.dynamic.ParameterInterface))")
	public void advice3(){
		System.out.println("advice3");
	}

}
