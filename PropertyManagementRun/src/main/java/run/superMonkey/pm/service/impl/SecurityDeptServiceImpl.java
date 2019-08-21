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
		System.out.println(securityno);
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


	@Override
	public int getCountByConditionWithSecurityNoWithPage(String securitysex, Integer securityage) throws Exception {
		return securityDeptMapper.selectCountByCondition(securitysex, securityage);
	}


	@Override
	public int getPageCountByConditionWithSecurityNoWithPage(String securitysex, Integer securityage, int rows)
			throws Exception {
		int pageCount=0;
		int count=this.getCountByConditionWithSecurityNoWithPage(securitysex, securityage);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}


	@Override
	public List<SecurityDept> getListByConditionWithSecurityWithPage(String securitysex, Integer securityage, int rows,
			int page) throws Exception {
		return securityDeptMapper.selectListByALLWithSecurityDeptWithPage(securitysex, securityage,rows*(page-1), rows);
	}


	//验证员工是否合法
	@Override
	public boolean checkIdExist(String securityno) throws Exception {
		boolean result=false;
		if(securityDeptMapper.selectCountByNo(securityno)>0) {
			result=true;
		}
		return result;
	}
	
	
	
	
}
