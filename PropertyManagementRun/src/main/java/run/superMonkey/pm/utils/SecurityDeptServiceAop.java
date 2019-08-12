package run.superMonkey.pm.utils;


import org.aopalliance.intercept.Joinpoint;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import run.superMonkey.pm.mapper.SecurityDeptMapper;
import run.superMonkey.pm.service.impl.SecurityDeptServiceImpl;


@Aspect
@Component
public class SecurityDeptServiceAop {
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Around("com.neusoft.busmis.pointcut.PointcutDefinition.serviceMethodForUser()")
	public Object methodAroundRun(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around方法調用后。。。。。");
		
		SqlSession session = ssf.openSession();
		
		SecurityDeptMapper securityDeptMapper =session.getMapper(SecurityDeptMapper.class);
		
		if(pjp.getTarget() instanceof SecurityDeptServiceImpl) {
			((SecurityDeptServiceImpl)pjp.getTarget()).setSecurityDeptMapper(securityDeptMapper);;
		}
		
		Object result = pjp.proceed();//调用目标对象的方法
		
		session.commit();
		session.close();
		
		return result;
	}
	
	
}
