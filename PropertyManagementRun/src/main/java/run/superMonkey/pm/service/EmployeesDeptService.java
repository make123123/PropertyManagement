package run.superMonkey.pm.service;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessDeptEntity;

public interface EmployeesDeptService {
    //增加部门
	public int insert(EmployessDeptEntity record)throws Exception;
	//删除部门
	public int delete(Integer deptno)throws Exception;
	//修改部门
	public int update(EmployessDeptEntity record)throws Exception;
	//查询部门
	public EmployessDeptEntity getById(Integer deptno)throws Exception;
	public List<EmployessDeptEntity> getListByALL()throws Exception;

    
}
