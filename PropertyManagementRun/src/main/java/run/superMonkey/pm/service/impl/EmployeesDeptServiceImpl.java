package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import run.superMonkey.pm.mapper.EmployeesDeptMapper;
import run.superMonkey.pm.model.entity.EmployessDeptEntity;
import run.superMonkey.pm.service.EmployeesDeptService;

@Service
@Transactional(rollbackFor = Exception.class)
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
	@Transactional(readOnly = true)
	public EmployessDeptEntity getByNo(Integer deptno) throws Exception {
		return edm.selectByPrimaryKey(deptno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployessDeptEntity> getListByALL() throws Exception {
		return edm.selectListByAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployessDeptEntity> getListByPage(int page, int rows)throws Exception {
		return edm.selectListByPage(rows*(page-1),rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getPageCountByCondition(int rows)throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition();
		if(count%rows==0) {
			pageCount=count/rows;
		}else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByCondition() throws Exception {
		return edm.selectCountByCondition();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean checkIdExist(Integer deptno) throws Exception {
		boolean result=false;
		if(edm.selectByPrimaryKey(deptno)!=null){
			result=true;
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public EmployessDeptEntity selectById(Integer deptno) throws Exception {
		return edm.selectByPrimaryKey(deptno);
	}

}
