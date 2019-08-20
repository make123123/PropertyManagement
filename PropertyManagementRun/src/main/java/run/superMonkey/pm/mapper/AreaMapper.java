package run.superMonkey.pm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import run.superMonkey.pm.model.entity.Area;

@Mapper
public interface AreaMapper {
	//c
	public void create(Area area) throws Exception;
	//u
	public void update(Area area) throws Exception;
	//d
	public void delete(Area area) throws Exception;
	//R  查询返回单个对象，同时取得关联的楼宇对象集合
	public Area selectByAreanoWithBuilding(Double areano) throws Exception;
	//R  取得列表，不取关联对象，不分页
	public List<Area> selectListByAllWithoutPage() throws Exception;
	//R  取得列表，不取关联对象，分页
	public List<Area> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得小区信息列表，分页模式
	public List<Area> selectListByConditionWithPage(@Param("areaname") String areaname,@Param("aaddress") String aaddress,@Param("developer") String developer,@Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得小区个数
	public int selectCountByCondition(@Param("areaname") String areaname,@Param("aaddress") String aaddress,@Param("developer") String developer) throws Exception;
	//检查指定的areano的小区个数，用于验证areano的小区是否存在
	public int selectCountByAreano(@Param("areano") Double areano) throws Exception;
}
