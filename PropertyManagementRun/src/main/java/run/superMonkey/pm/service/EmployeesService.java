package run.superMonkey.pm.service;

import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEntity;

public interface EmployeesService {
	//查
	public List<EmployessEntity> getListByAll()throws Exception;
}
