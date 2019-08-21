package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;

import run.superMonkey.pm.model.entity.SecurityBoxRecord;

//安保岗亭登记业务接口
public interface SecurityBoxRecordService {
	
	// C
	public void register(SecurityBoxRecord securityBoxRecord) throws Exception;

	// U
	public void update(SecurityBoxRecord securityBoxRecord) throws Exception;

	// D
	public void delete(String visitname) throws Exception;

	//根据岗亭号查询
	SecurityBoxRecord getByPrimaryKey(Double boxno) throws Exception;

	SecurityBoxRecord getByVisitName(String visitname) throws Exception;

	List<SecurityBoxRecord> selectListByAll() throws Exception;

	// 根据综合检索条件取得员工显示的页数
	int getCountByConditionWithBoxnoWithPage(Date boxdate, Double dutyno) throws Exception;

	// 根据综合检索条件取得员工显示的页数
	int getPageCountByConditionWithBoxnoWithPage(Date boxdate, Double dutyno, int rows)
			throws Exception;

	// 根据综合检索条件取得员工列表，取得关联的部门，不取关联的角色列表，分页模式
	List<SecurityBoxRecord> getListByConditionWithBoxWithPage(Date boxdate, Double dutyno, int rows,
			int page) throws Exception;

	// 验证岗亭ID是否存在
	boolean checkIdExist(Double boxno) throws Exception;
	
}
