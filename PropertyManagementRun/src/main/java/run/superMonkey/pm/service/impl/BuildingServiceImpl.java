package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import run.superMonkey.pm.mapper.BuildingMapper;
import run.superMonkey.pm.model.entity.Building;
import run.superMonkey.pm.service.IBuildingService;

@Service
public class BuildingServiceImpl implements IBuildingService{

	
	@Autowired
	private BuildingMapper buildingMapper=null;
	@Override
	public void register(Building building) throws Exception {
		buildingMapper.create(building);
		
	}

	@Override
	public void modify(Building building) throws Exception {
		buildingMapper.update(building);
		
	}

	@Override
	public void delete(Building building) throws Exception {
		buildingMapper.delete(building);
	}

	@Override
	public Building getByBuildingnoWithAreaBuildingTypeAndRooms(Double buildingno) throws Exception {
		return buildingMapper.selectByBuildingnoWithAreaAndBuildingTypeAndRooms(buildingno);
	}

	@Override
	public List<Building> getListByAllWithoutPage() throws Exception {
		return buildingMapper.selectListByAllWithoutPage();
	}

	@Override
	public List<Building> getListByAllWithPage(int rows, int page) throws Exception {
		return buildingMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public List<Building> getListByAllWithAreaAndBuildingTypeWithoutRooms() throws Exception {
		return buildingMapper.selectListByAllWithAreaAndBuildingTypeWithoutRooms();
	}

	@Override
	public List<Building> getListByConditionWithAreaAndBuildingtypeAndRoomNoWithPage(Double areaNo,Double buildingtypeNo, Double roomNo,
			int rows,int page) throws Exception {
		return buildingMapper.selectListByConditionWithAreaAndBuildingtypeNoAndRoomNoWithPage(areaNo,buildingtypeNo, roomNo,  rows*(page-1), rows);
	}

	@Override
	public int getCountByConditionWithPage(Double areaNo,Double buildingtypeNo, Double roomNo) throws Exception {
		return buildingMapper.selectCountByCondition(areaNo,buildingtypeNo,roomNo);
	}

	@Override
	public int getPageCountByConditionWithAreaAndBuildingTypeAndRoomWithPage(Double areaNo,Double buildingtypeNo,Double roomNo,int rows)
			throws Exception {
		int pageCount=0;
		int count=this.getCountByConditionWithPage(areaNo,buildingtypeNo,roomNo);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public void addRooms(Double buildingno, Double[] rooms) throws Exception {
		buildingMapper.addRooms(buildingno, rooms);
		
	}

	@Override
	public void deleteRooms(Double buildingno) throws Exception {
		buildingMapper.deleteRooms(buildingno);
		
	}

	@Override
	public boolean checkBuildingnoExist(Double buildingno) throws Exception {
		boolean result=false;
		if(buildingMapper.selectCountByBuildingno(buildingno)>0) {
			result=true;
		}
		return result;
	}

}
