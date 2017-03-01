package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	@Test
	public void testAutoWired(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
		ClassA a = ac.getBean(ClassA.class);
		System.out.println(a.b);
	}
}
