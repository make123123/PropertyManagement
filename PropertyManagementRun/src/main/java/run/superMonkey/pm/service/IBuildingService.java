package run.superMonkey.pm.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.Building;




public interface IBuildingService {
		public void register(Building building) throws Exception;

		public void modify(Building building) throws Exception;

		public void delete(Building building) throws Exception;
			
		public Building getByBuildingnoWithAreaBuildingTypeAndRooms(Double buildingno) throws Exception;
		
		public List<Building> getListByAllWithoutPage() throws Exception;
		
		public List<Building> getListByAllWithPage(int rows,int page) throws Exception;
		
		public  List<Building> getListByAllWithAreaAndBuildingTypeWithoutRooms() throws Exception;
	
		public List<Building> getListByConditionWithAreaAndBuildingtypeAndRoomNoWithPage(Double areaNo,Double buildingtypeNo,int rows,int page) throws Exception;
	
		public int getCountByConditionWithPage(Double areaNo,Double buildingtypeNo) throws Exception;
		
		public int getPageCountByConditionWithAreaAndBuildingTypeAndRoomWithPage(Double areaNo,Double buildingtypeNo,int rows) throws Exception;
		
		
		
		public  boolean checkBuildingnoExist(Double buildingno) throws Exception;
		
}
