package run.superMonkey.pm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import run.superMonkey.pm.mapper.EmployessMapper;
import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.EmployeesService;
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
	private EmployessMapper em=null;
	
	@Override
	public void insert(EmployessEntity record) throws Exception {
		em.insertSelective(record);
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
	@Transactional(readOnly = true)
	public EmployessEntity selectById(int empid) throws Exception {
		return em.selectByPrimaryKey(empid);
	}
	@Override
	@Transactional(readOnly = true)
	public List<EmployessEntity> getListByAll() throws Exception {
		return em.selectListByAll();
	}
	@Override
	public List<EmployessEntity> getListByPage(int deptno, String sex, Date joindate, int page, int rows)
			throws Exception {
		return em.selectListByPage(deptno,sex,joindate,rows*(page-1), rows);
	}
	@Override
	public boolean checkIdExist(int empid)throws Exception{
		boolean result=false;
		
			if(em.selectByPrimaryKey(empid)!=null){
				result=true;
			}
			
		return result;
	}
	@Override
	public int getCountByCondition(int deptno, String sex, Date joindate) throws Exception {
		return em.selectCountByCondition(deptno, sex, joindate);
	}
	@Override
	public int getPageCountByCondition(int deptno, String sex, Date joindate, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(deptno, sex, joindate);
		if(count%rows==0) {
			pageCount=count/rows;
		}else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}
}
