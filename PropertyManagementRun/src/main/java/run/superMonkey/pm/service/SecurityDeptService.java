package run.superMonkey.pm.service;

import java.util.List;

import run.superMonkey.pm.model.entity.SecurityDept;


//保安部门业务接口
public interface SecurityDeptService {
	
	//C
	public void register(SecurityDept securityDept) throws Exception;
	//U
	public void update(SecurityDept securityDept) throws Exception;
	//D
	public void delete(Integer securityno) throws Exception;
	
	//R
	SecurityDept getByPrimaryKey(Integer securityno) throws Exception;
	
	List<SecurityDept> selectListByAll() throws Exception;
	
	
}
