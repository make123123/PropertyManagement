package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.RoyaltyMapper;
import run.superMonkey.pm.model.entity.RoyaltyEntity;
import run.superMonkey.pm.service.RoyaltyService;
@Service
public class RoyaltyServiceImpl implements RoyaltyService {
	@Autowired
	RoyaltyMapper royaltymapper=null;
	@Override
	public void register(RoyaltyEntity royaltyEntity) throws Exception {
		royaltymapper.create(royaltyEntity);
	}

	@Override
	public void modify(RoyaltyEntity royaltyEntity) throws Exception {
		royaltymapper.update(royaltyEntity);
	}

	@Override
	public void delete(RoyaltyEntity royaltyEntity) throws Exception {
		royaltymapper.delete(royaltyEntity);
	}

	@Override
	public List<RoyaltyEntity> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return royaltymapper.selectListByAll();
	}

	@Override
	public RoyaltyEntity getbyNo(double no) throws Exception {
		// TODO Auto-generated method stub
		return royaltymapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return royaltymapper.selectCountByAll();
	}

}
