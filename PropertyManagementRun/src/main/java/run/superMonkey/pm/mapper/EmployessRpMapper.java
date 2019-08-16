package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessRpEntity;


public interface EmployessRpMapper {
	//增
    public void insertSelective(EmployessRpEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer rpno)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessRpEntity record)throws Exception;
    //查
    public EmployessRpEntity selectByPrimaryKey(Integer rpno)throws Exception;
	public List<EmployessRpEntity> selectListByAll()throws Exception; 
}
