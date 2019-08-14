package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEntity;

public interface EmployessMapper {
	//查
	public List<EmployessEntity> selectListByAll()throws Exception; 
}
