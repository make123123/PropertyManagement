package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEntity;

public interface EmployessMapper {
	//增
    public void insertSelective(EmployessEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer empid)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessEntity record)throws Exception;
    //查
    public EmployessEntity selectByPrimaryKey(Integer empid)throws Exception;
	public List<EmployessEntity> selectListByAll()throws Exception; 
}
