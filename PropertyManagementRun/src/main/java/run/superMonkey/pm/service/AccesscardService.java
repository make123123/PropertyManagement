package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.AccesscardEntity;



public interface AccesscardService {
	public AccesscardEntity register(AccesscardEntity accesscardEntity) throws Exception;
	public void modify(AccesscardEntity accesscardEntity) throws Exception;
	public void delete(AccesscardEntity accesscardEntity) throws Exception;
	//R方法-查询 取得列表
	public List<AccesscardEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public AccesscardEntity getbyNo(String no)throws Exception;
	//取得所有个数
	public int getCountByAll()throws Exception;
	//分页查询
	public List<AccesscardEntity> getListByPage(String grantno,String carno,String cardtype,int page,int rows) throws Exception;
}
