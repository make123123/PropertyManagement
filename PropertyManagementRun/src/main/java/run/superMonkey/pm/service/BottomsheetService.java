package run.superMonkey.pm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.BottomsheetEntity;

import run.superMonkey.pm.model.entity.BottomsheetEntity;



public interface BottomsheetService {
	public void register(BottomsheetEntity bottomsheetEntity) throws Exception;
	public void modify(BottomsheetEntity bottomsheetEntity) throws Exception;
	public void delete(BottomsheetEntity bottomsheetEntity) throws Exception;
	//R方法-查询 取得列表
	public List<BottomsheetEntity> getListByAll()throws Exception;
	//取得指定的系统功能对象
	public BottomsheetEntity getbyNo(double no)throws Exception;
	//取得所有功能的个数
	public int getCountByAll()throws Exception;
}
