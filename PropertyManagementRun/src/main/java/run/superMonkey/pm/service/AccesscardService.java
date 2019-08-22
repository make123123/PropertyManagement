package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.AccesscardEntity;



public interface AccesscardService {
	public void register(AccesscardEntity accesscardEntity) throws Exception;
	public void modify(AccesscardEntity accesscardEntity) throws Exception;
	public void delete(AccesscardEntity accesscardEntity) throws Exception;
	//R方法-查询 取得列表
	public List<AccesscardEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public AccesscardEntity getbyNo(String no)throws Exception;
	//取得所有个数
	public int getCountByAll()throws Exception;
	//分页查询
	public List<AccesscardEntity> getListByPage(String grantno,String cardtype,String carno,int page,int rows) throws Exception;
	//根据综合检索条件取得员工个数
	public int getCountByCondition(String grantno,String cardtype,String carno)throws Exception;
	
	public int getPageCountByCondition(String grantno,String cardtype,String carno,int rows)throws Exception;
	
	//查看员工是否存在
	public boolean checkIdExist(String cardno) throws Exception;
}
