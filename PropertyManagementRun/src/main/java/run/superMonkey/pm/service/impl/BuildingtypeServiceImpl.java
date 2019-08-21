package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.BuildingTypeMapper;
import run.superMonkey.pm.mapper.RoomMapper;
import run.superMonkey.pm.model.entity.BuildingType;
import run.superMonkey.pm.service.IBuildingTypeService;

@Service
public class BuildingtypeServiceImpl implements IBuildingTypeService{

	@Autowired
	private BuildingTypeMapper buildingtypeMapper=null;
	@Override
	public List<BuildingType> getListByAllWithoutPage() throws Exception {
		return buildingtypeMapper.selectListByAllWithoutPage();
	}

}
