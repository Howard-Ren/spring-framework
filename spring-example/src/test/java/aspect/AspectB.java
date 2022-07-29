package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author rhx
 * @date 2022/7/27 17:34
 **/
@Aspect
public class AspectB {

	@Pointcut("execution(* test*(..))")
	public void pt() {
	}

	@Before("pt()")
	public void before() {
		System.out.println("aspectB before");
	}

	@After("pt()")
	public void after() {
		System.out.println("aspectB after");
	}

	@AfterReturning("pt()")
	public void afterReturning() {
		System.out.println("aspectB after returning");
	}

	@AfterThrowing("pt()")
	public void afterThrowing() {
		System.out.println("aspectB after throwing");
	}

	@Around("pt()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("aspectB around before ");
		final Object proceed = proceedingJoinPoint.proceed();
		System.out.println("aspectB around after");
		return proceed;
	}

}
