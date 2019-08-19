package run.superMonkey.pm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.ServiceregistrationEntity;

import run.superMonkey.pm.model.entity.ServiceregistrationEntity;



public interface ServiceregistrationService {
	public void register(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	public void modify(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	public void delete(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	//R方法-查询 取得列表
	public List<ServiceregistrationEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public ServiceregistrationEntity getbyNo(double no)throws Exception;
	//取得所有功能的个数
	public int getCountByAll()throws Exception;
}
