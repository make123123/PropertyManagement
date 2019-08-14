package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.EmployessMapper;
import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
	private EmployessMapper em=null;
	@Override
	public List<EmployessEntity> getListByAll() throws Exception {
		return em.selectListByAll();
	}

}
