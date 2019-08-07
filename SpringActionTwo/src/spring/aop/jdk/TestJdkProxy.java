package spring.aop.jdk;

import org.junit.Test;

public class TestJdkProxy {
	
	@Test
	public void	test1() throws Exception {
		ItemsService is = BeanFactory.createService();
		is.addItems(5, 10);
		is.deleteItems();
	}
}
