package spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BeanFactory {
	public static ItemsService createService() {
		// 目标类
		final ItemsService itemsService = new ItemsServiceImpl();
		// 切面类
		final AdviceClass advice = new AdviceClass();
		/**
		 * 调用Proxy.newProxyInstance((ClassLoader loader, 类<?>[] interfaces, InvocationHandler h))生成我们的代理类
		 * 参数:
		 * loader  类加载器,动态代理类运行时创建,任何类的运行都需要类加载器
		 * interfaces  目标类的接口,jdk代理需要接口才可以实现
		 * h      处理类,接口,必须实现的,每一次执行一次方法,通过代理调用一次invoke
		 * 			(Object proxy, Method method, Object[] args)
		 * 			ivoke参数:
		 * 				proxy:代理对象类
		 * 				method:调用的方法
		 * 				args:调用方法的实现类	
		 */
		ItemsService itemsServiceProxy = (ItemsService) Proxy.newProxyInstance(BeanFactory.class.getClassLoader(),
				itemsService.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						advice.advice1();
						Object obj = method.invoke(itemsService, args);
						advice.advice2();
						advice.advice3();
						return obj;
					}
				});
		return itemsServiceProxy;

	}
}
