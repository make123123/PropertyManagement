package run.superMonkey.pm.service;

import java.util.List;

import run.superMonkey.pm.model.entity.SecurityDept;


//保安部门业务接口
public interface SecurityDeptService {
	
	
	
	public SecurityDept getByPrimaryKey(Integer securityno) throws Exception;
	
	
	
}
