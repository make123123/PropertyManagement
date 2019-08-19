package run.superMonkey.pm.service;

import java.util.List;


import org.springframework.stereotype.Service;

import run.superMonkey.pm.model.entity.ComplaintsuggestionEntity;

public interface ComplaintsuggestionService {
	public void register(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	public void modify(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	public void delete(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	//R方法-查询 取得列表
	public List<ComplaintsuggestionEntity > getListByAll()throws Exception;
	//取得指定的系统功能对象
	public ComplaintsuggestionEntity getbyNo(double no)throws Exception;
	//取得所有功能的个数
	public int getCountByAll()throws Exception;
}
