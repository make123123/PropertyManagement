package run.superMonkey.pm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.VehiclearchiveEntity;

public interface VehiclearchiveService {
	public void register(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;
	public void modify(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;
	public void delete(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;
	//R方法-查询 取得列表
	public List<VehiclearchiveEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public VehiclearchiveEntity getbyNo(String no)throws Exception;
	//分页查询
	public List<VehiclearchiveEntity> getListByPage(String carno,double customerno,String state,int page,int rows) throws Exception;
	//根据综合检索条件取得员工个数	
	public int getCountByCondition(String carno,double customerno,String state)throws Exception;
	
	public int getPageCountByCondition(String carno, double customerno, String state,int rows)throws Exception;
	//查看员工是否存在
	public boolean checkIdExist(String carno) throws Exception;
}
