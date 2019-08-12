package run.superMonkey.pm.mapper;


import java.util.List;

import run.superMonkey.pm.model.entity.EmployessDeptEntity;

public interface EmployeesDeptMapper {
	//增
    public void insertSelective(EmployessDeptEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer deptno)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessDeptEntity record)throws Exception;
    //查
    public EmployessDeptEntity selectByPrimaryKey(Integer deptno)throws Exception;
    public List<EmployessDeptEntity> selectListByAll()throws Exception;


}
