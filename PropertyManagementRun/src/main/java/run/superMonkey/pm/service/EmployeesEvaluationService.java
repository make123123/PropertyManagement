package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;

import run.superMonkey.pm.model.entity.EmployessEvaluationEntity;

public interface EmployeesEvaluationService {
	//增加人员
	public void insert(EmployessEvaluationEntity record)throws Exception;
	//删除人员
	public void delete(Integer evaluationno)throws Exception;
	//修改人员信息
	public void update(EmployessEvaluationEntity record)throws Exception;
	//查询人员信息
	public EmployessEvaluationEntity selectById(int evaluationno)throws Exception;
	public List<EmployessEvaluationEntity> getListByAll()throws Exception;
	//根据综合检索条件取得员工考评列表，取得关联的员工，分页模式
	public List<EmployessEvaluationEntity> getListByPage(int empid,String evaluationgrade,Date evaluationdate,int page,int rows) throws Exception;
	//根据综合检索条件取得员工个数
	public int getCountByCondition(int empid,String evaluationgrade,Date evaluationdate)throws Exception;
	//根据综合检索条件取得总页数
	public int getPageCountByCondition(int empid,String evaluationgrade,Date evaluationdate,int rows)throws Exception;
	//查ID是否存在
	public boolean checkIdExist(int evaluationno) throws Exception;
	
}
