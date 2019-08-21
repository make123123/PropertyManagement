package run.superMonkey.pm.service;

import java.util.Date;
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
	
	//根据综合检索条件取得员工显示的页数
	int getCountByConditionWithSecurityNoWithPage(String securitysex,Integer securityage) throws Exception;
	//根据综合检索条件取得员工显示的页数
	int getPageCountByConditionWithSecurityNoWithPage(String securitysex,Integer securityage,int rows) throws Exception;
	//根据综合检索条件取得员工列表，取得关联的部门，不取关联的角色列表，分页模式
	List<SecurityDept> getListByConditionWithSecurityWithPage(String securitysex,Integer securityage,int rows,int page) throws Exception;
	
	//验证员工ID是否存在
	boolean checkIdExist(String securityno) throws Exception;
	
}
