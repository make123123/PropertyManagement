package run.superMonkey.pm.service;

import java.util.List;


import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.AccesscardEntity;


import run.superMonkey.pm.model.entity.AccesscardEntity;


public interface AccesscardService {
	public AccesscardEntity register(AccesscardEntity accesscardEntity) throws Exception;
	public void modify(AccesscardEntity accesscardEntity) throws Exception;
	public void delete(AccesscardEntity accesscardEntity) throws Exception;
	//R方法-查询 取得列表
	public List<AccesscardEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public AccesscardEntity getbyNo(double no)throws Exception;
	//取得所有功能的个数
	public int getCountByAll()throws Exception;
}
