package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import run.superMonkey.pm.mapper.SecurityDeptMapper;
import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;

public class SecurityDeptServiceImpl implements SecurityDeptService{
	
	@Autowired
	private SecurityDeptMapper securityDeptMapper = null;
	//属性Set注入方法
	
	
	public void setSecurityDeptMapper(SecurityDeptMapper securityDeptMapper) {
		this.securityDeptMapper = securityDeptMapper;
	}
	
	
	
	
	@Override
	public SecurityDept getByPrimaryKey(Integer securityno) throws Exception {
		
		return securityDeptMapper.selectByPrimaryKey(securityno);
		
		
	}
	
}
