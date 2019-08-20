package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.HouseType;

public interface HouseTypeMapper {
	//c
	public void create(HouseType housetype) throws Exception;
	//u
	public void update(HouseType housetype) throws Exception;
	//d
	public void delete(HouseType housetype) throws Exception;
	//R  取得列表
	public List<HouseType> selectListByAll() throws Exception;
	//R  查询返回单个对象，一般根据表的主键字段值获取
	public HouseType selectByTypeno(Double typeno) throws Exception;
}
