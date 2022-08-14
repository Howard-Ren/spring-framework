package configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberClassTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MemberClass.class);
		MemberClass.StaticClass staticInnerClass = context.getBean(MemberClass.StaticClass.class);
		MemberClass.NonStaticClass nonStaticInnerClass = context.getBean(MemberClass.NonStaticClass.class);
		MemberClass memberClass = context.getBean(MemberClass.class);
		System.out.println(staticInnerClass);
		System.out.println(nonStaticInnerClass);
		System.out.println(memberClass);
	}
}
