package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.EmployeesDeptMapper;
import run.superMonkey.pm.model.entity.EmployessDeptEntity;
import run.superMonkey.pm.service.EmployeesDeptService;

@Service
public class EmployeesDeptServiceImpl implements EmployeesDeptService {
    @Autowired
	private EmployeesDeptMapper edm=null;
   
	@Override
	public void insert(EmployessDeptEntity record) throws Exception {
		edm.insertSelective(record);
	}

	@Override
	public void delete(Integer deptno) throws Exception {
		edm.deleteByPrimaryKey(deptno);	
	}

	@Override
	public void update(EmployessDeptEntity record) throws Exception {
	   edm.updateByPrimaryKeySelective(record);
	}

	@Override
	public EmployessDeptEntity getByNo(Integer deptno) throws Exception {
		return edm.selectByPrimaryKey(deptno);
	}

	@Override
	public List<EmployessDeptEntity> getListByALL() throws Exception {
		return edm.selectListByAll();
		
	}

}
