package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import run.superMonkey.pm.model.entity.Building;

@Mapper
public interface BuildingMapper {
		//c
		public void create(Building building) throws Exception;
		//u
		public void update(Building building) throws Exception;
		//d
		public void delete(Building building) throws Exception;
		//R  查询返回单个对象，同时取得关联的建筑类型和房间列表
		
		public Building selectByBuildingnoWithAreaAndBuildingTypeAndRooms(Double buildingno) throws Exception;
		//R  取得列表，不取关联对象，不分页
		public List<Building> selectListByAllWithoutPage() throws Exception;
		//R  取得列表，不取关联对象，分页
		public List<Building> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
		
		//取得所有楼宇列表，同时取关联的建筑类型，小区，不取关联的房间集合
		public List<Building> selectListByAllWithAreaAndBuildingTypeWithoutRooms() throws Exception;
				
				
		//根据综合检索条件取得楼宇列表，取得关联的建筑类型,小区，不取关联的房间集合，分页模式
		public List<Building> selectListByConditionWithAreaAndBuildingtypeNoAndRoomNoWithPage(@Param("areaNo") Double areaNo,@Param("buildingtypeNo") Double buildingtypeNo, @Param("start") int start,@Param("rows") int rows) throws Exception;
		//根据综合检索条件取得员工个数
		public int selectCountByCondition(@Param("areaNo") Double areaNo,@Param("buildingtypeNo") Double buildingtypeNo) throws Exception;
		
		
		//检查指定的ID的员工个数，用于验证员工ID是否存在
		public int selectCountByBuildingno(@Param("buildingno") Double buildingno) throws Exception;
}
