package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author rhx
 * @date 2022/7/27 17:34
 **/
@Aspect
public class AspectA {

	@Pointcut("execution(* test*(..))")
	public void pt() {
	}

	@Before("pt()")
	public void before2() {
		System.out.println("aspectA before");
	}

//	@Before("pt()")
	public void before() {
		System.out.println("aspectA before");
	}

//	@Before("pt()")
	public void before3() {
		System.out.println("aspectA before");
	}

	@After("pt()")
	public void after() {
		System.out.println("aspectA after");
	}

	@AfterReturning("pt()")
	public void afterReturning() {
		System.out.println("aspectA after returning");
	}

	@AfterThrowing("pt()")
	public void afterThrowing() {
		System.out.println("aspectA after throwing");
	}

	@Around("pt()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("aspectA around before ");
		final Object proceed = proceedingJoinPoint.proceed();
		System.out.println("aspectA around after");
		return proceed;
	}

	public void test(){

	}

}
