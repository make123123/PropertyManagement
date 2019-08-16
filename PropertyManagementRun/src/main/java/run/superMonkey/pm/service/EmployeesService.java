package run.superMonkey.pm.service;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEntity;

public interface EmployeesService {
	//增加人员
	public EmployessEntity insert(EmployessEntity record)throws Exception;
	//删除人员
	public void delete(Integer empid)throws Exception;
	//修改人员信息
	public void update(EmployessEntity record)throws Exception;
	//查询人员信息
	public EmployessEntity selectById(Integer empid)throws Exception;
	public List<EmployessEntity> getListByAll()throws Exception;
}
