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
	public EmployessEntity insert(EmployessEntity record) throws Exception {
		em.insertSelective(record);
		return record;
	}
	@Override
	public void delete(Integer empid) throws Exception {
		em.deleteByPrimaryKey(empid);
	}
	@Override
	public void update(EmployessEntity record) throws Exception {
		em.updateByPrimaryKeySelective(record);
	}
	@Override
	public EmployessEntity selectById(Integer empid) throws Exception {
		return em.selectByPrimaryKey(empid);
	}
	@Override
	public List<EmployessEntity> getListByAll() throws Exception {
		return em.selectListByAll();
	}
}
