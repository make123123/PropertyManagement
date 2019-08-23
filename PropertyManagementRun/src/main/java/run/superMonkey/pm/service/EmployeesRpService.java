package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEntity;

public interface EmployeesRpService {
	//增加人员
	public void insert(EmployessEntity record)throws Exception;
	//删除人员
	public void delete(Integer empid)throws Exception;
	//修改人员信息
	public void update(EmployessEntity record)throws Exception;
	//查询人员信息
	public EmployessEntity selectById(int empid)throws Exception;
	public List<EmployessEntity> getListByAll()throws Exception;
	//根据综合检索条件取得员工列表，取得关联的部门，分页模式
	public List<EmployessEntity> getListByPage(int deptno,String sex,Date joindate,int page,int rows) throws Exception;
	//根据综合检索条件取得员工个数
	public int getCountByCondition(int deptno,String sex,Date joindate)throws Exception;
	//根据综合检索条件取得总页数
	public int getPageCountByCondition(int deptno,String sex,Date joindate,int rows)throws Exception;
	//查ID是否存在
	public boolean checkIdExist(int empid) throws Exception;
	
}
