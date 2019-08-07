package concert;

import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	//此方法不需要有任何执行,仅仅是一个表达式,让@PointCut去依附,仅仅是一个标识
	@Pointcut("execution(** concert.ServiceTest.service3(Integer)) && args(param1)")
	public void performance(Integer param1) {
	}
	
	//有参数的PointCut
//	@Pointcut("execution(* concert.ServiceTest.perform(..)) && args(a ,b)")
//	public void performance(Integer a, String b) {
//	}
		
	//来看演出需要静音手机
	@Before("performance(param1)")
	public void silenceCellphones(Integer param1) {
		
		System.out.println("Silenciong cell phones" + "  "+param1);
	}
	
	//静音手机
	@Before("performance()")
	public void takeSeats() {
		System.out.println("takingSeats");
	}
	
	//表演的成功有掌声
	@AfterReturning("performance()")
	public void applause() {
		System.out.println("CLAP CLAP");
	}
	
	//表演出现了异常 会要求退票
	@AfterThrowing("performance())")
	public void demanRefund() {
		System.out.println("Demanding a refund");
	}
}
