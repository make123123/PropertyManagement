package run.superMonkey.pm.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import run.superMonkey.pm.model.entity.RoyaltyEntity;

import run.superMonkey.pm.model.entity.RoyaltyEntity;


public interface RoyaltyService {
	public void register(RoyaltyEntity royaltyEntity) throws Exception;
	public void modify(RoyaltyEntity royaltyEntity) throws Exception;
	public void delete(RoyaltyEntity royaltyEntity) throws Exception;
	//R方法-查询 取得列表
	public List<RoyaltyEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public RoyaltyEntity getbyNo(double no)throws Exception;
	//取得所有功能的个数
	public int getCountByAll()throws Exception;
}
