package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import run.superMonkey.pm.model.entity.BuildingType;

@Mapper
public interface BuildingTypeMapper {
		//c
		public void create(BuildingType buildingType) throws Exception;
		//u
		public void update(BuildingType buildingType) throws Exception;
		//d
		public void delete(BuildingType buildingType) throws Exception;
		//R  取得列表，不取关联对象，不分页
		public List<BuildingType> selectListByAllWithoutPage() throws Exception;
}
