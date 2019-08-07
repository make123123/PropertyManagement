package spring.aop.cglib;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class BeanFactory {
	public static ItemsService createService() {
		// 目标类
		final ItemsServiceImpl itemsService = new ItemsServiceImpl();
		// 切面类
		final AdviceClass advice = new AdviceClass();
		// .代理类 ，采用cglib，底层创建目标类的子类
		Enhancer enhancer = new Enhancer();
		//确定父类
		enhancer.setSuperclass(itemsService.getClass());
		/* 设置回调函数 , MethodInterceptor接口 等效 jdk InvocationHandler接口
		 * 	intercept() 等效 jdk  invoke()
		 * 		参数1、参数2、参数3：以invoke一样
		 * 		参数4：methodProxy 方法的代理
		 */
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
			
				advice.advice1();
				advice.advice2();
				
				//执行目标类的方法
				Object obj = method.invoke(itemsService, args);
				// * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
				methodProxy.invokeSuper(proxy, args);
				
				//后
				advice.advice3();
				
				return obj;
				
			}
		});		
		//3.4 创建代理
		ItemsServiceImpl proxService = (ItemsServiceImpl) enhancer.create();
				
				return proxService;
		
		

	}
}
