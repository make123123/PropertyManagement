package run.superMonkey.pm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import run.superMonkey.pm.mapper.EmployessEvaluationMapper;
import run.superMonkey.pm.model.entity.EmployessEvaluationEntity;
import run.superMonkey.pm.service.EmployeesEvaluationService;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeesEvaluationServiceImpl implements EmployeesEvaluationService{
	@Autowired
	private EmployessEvaluationMapper em=null;
	@Override
	public void insert(EmployessEvaluationEntity record) throws Exception {
		em.insertSelective(record);
	}

	@Override
	public void delete(Integer evaluationno) throws Exception {
		em.deleteByPrimaryKey(evaluationno);
	}

	@Override
	public void update(EmployessEvaluationEntity record) throws Exception {
		em.updateByPrimaryKeySelective(record);
		
	}

	@Override
	@Transactional(readOnly = true)
	public EmployessEvaluationEntity selectById(int evaluationno) throws Exception {
		return em.selectByPrimaryKey(evaluationno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployessEvaluationEntity> getListByAll() throws Exception {
		return em.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployessEvaluationEntity> getListByPage(int empid, String evaluationgrade, Date evaluationdate,
			int page, int rows) throws Exception {
		
		return em.selectListByPage(empid,evaluationgrade,evaluationdate,rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByCondition(int empid, String evaluationgrade, Date evaluationdate) throws Exception {
		return em.selectCountByCondition(empid, evaluationgrade, evaluationdate);
	}

	@Override
	@Transactional(readOnly = true)
	public int getPageCountByCondition(int empid, String evaluationgrade, Date evaluationdate, int rows)
			throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(empid,evaluationgrade,evaluationdate);
		if(count%rows==0) {
			pageCount=count/rows;
		}else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public boolean checkIdExist(int evaluationno) throws Exception {
		boolean result=false;
		
		if(em.selectByPrimaryKey(evaluationno)!=null){
			result=true;
		}
	return result;
	}

	@Override
	public boolean checkDate(Date evaluationdate) throws Exception {
		boolean result =false;
		if(em.checkDate(evaluationdate)!=null) {
			return true;
		}
		return result;
	}

}
