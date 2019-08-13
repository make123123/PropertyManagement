package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.SecurityDeptMapper;
import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;


@Service
public class SecurityDeptServiceImpl implements SecurityDeptService{
	
	@Autowired
	private SecurityDeptMapper securityDeptMapper ;
	
	
	@Override
	public SecurityDept getByPrimaryKey(Integer securityno) throws Exception {
		
		return securityDeptMapper.selectByPrimaryKey(securityno);
	}


	@Override
	public void register(SecurityDept securityDept) throws Exception {
		securityDeptMapper.insert(securityDept);
	}

	@Override
	public void delete(Integer securityno) throws Exception {
		securityDeptMapper.deleteByPrimaryKey(securityno);
	}
	
	@Override
	public void update(SecurityDept securityDept) throws Exception {
		securityDeptMapper.updateByPrimaryKey(securityDept);
	}

	@Override
	public List<SecurityDept> selectListByAll() throws Exception {
		return securityDeptMapper.selectListByAll();
	}
	
}
