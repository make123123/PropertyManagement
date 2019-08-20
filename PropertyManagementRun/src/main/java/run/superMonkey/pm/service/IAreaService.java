package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;


import run.superMonkey.pm.model.entity.Area;


public interface IAreaService {
	    //添加小区信息
		public void register(Area area) throws Exception;
		//修改小区信息
		public void modify(Area area) throws Exception;
		//删除小区信息
		public void delete(Area area) throws Exception;
		//根据小区编号查询小区
		public Area getByAreano(Double areano) throws Exception;
		//取得所有小区信息列表,不取关联,不分页
		public List<Area> getListByAllWithoutPage() throws Exception;
		//取得所有小区信息列表，不取关联,分页模式
		public List<Area>getListByAllWithPage(int rows,int page) throws Exception;
		//根据综合检索条件取得小区个数
		public int getCount(String areaname,String aaddress,String developer) throws Exception;
		//根据综合检索条件取得小区显示的页数
		public int getPageCount(String areaname,String aaddress,String developer,int rows) throws Exception;
		//根据综合检索条件取得小区列表，不取关联，分页模式
		public List<Area> getListByConditionWithPage(String areaname,String aaddress,String developer,int rows,int page) throws Exception;
		//验证小区areano是否存在
		public  boolean checkAreanoExist(Double areano) throws Exception;
}
