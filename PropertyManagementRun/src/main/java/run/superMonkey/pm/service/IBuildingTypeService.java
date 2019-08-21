package run.superMonkey.pm.service;

import java.util.List;


import run.superMonkey.pm.model.entity.BuildingType;

public interface IBuildingTypeService {
	public List<BuildingType> getListByAllWithoutPage() throws Exception;
}
