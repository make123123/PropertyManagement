package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.VehiclearchiveMapper;
import run.superMonkey.pm.model.entity.VehiclearchiveEntity;
import run.superMonkey.pm.service.VehiclearchiveService;

@Service
public class VehiclearchiveServiceImpl implements VehiclearchiveService {
	@Autowired
	VehiclearchiveMapper vehiclearchiveMapper=null;
	@Override
	public void register(VehiclearchiveEntity vehiclearchiveEntity) throws Exception {
		vehiclearchiveMapper.create(vehiclearchiveEntity);
	}

	@Override
	public void modify(VehiclearchiveEntity vehiclearchiveEntity) throws Exception {
		vehiclearchiveMapper.update(vehiclearchiveEntity);
	}

	@Override
	public void delete(VehiclearchiveEntity vehiclearchiveEntity) throws Exception {
		vehiclearchiveMapper.delete(vehiclearchiveEntity);
	}

	@Override
	public List<VehiclearchiveEntity> getListByAll() throws Exception {
		return vehiclearchiveMapper.selectListByAll();
	}

	@Override
	public VehiclearchiveEntity getbyNo(String no) throws Exception {
		return vehiclearchiveMapper.selectByNo(no);
	}
	
	@Override
	public List<VehiclearchiveEntity> getListByPage(String carno, double customerno, String state, int page, int rows)
			throws Exception {
		// TODO Auto-generated method stub
		return vehiclearchiveMapper.selectListByPage(carno, customerno, state, (page-1)*rows, rows);
	}

	@Override
	public int getPageCountByCondition(String carno, double customerno, String state)
			throws Exception {
		// TODO Auto-generated method stub
		return vehiclearchiveMapper.selectCountByCondition(carno,customerno,state);
	}
	@Override
	public boolean checkIdExist(String carno) throws Exception {
		boolean res=false;
		if(vehiclearchiveMapper.selectByNo(carno)!=null)res=true;
		return res;
	}

}
