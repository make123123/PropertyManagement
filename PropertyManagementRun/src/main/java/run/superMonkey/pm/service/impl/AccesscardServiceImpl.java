package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.AccesscardMapper;
import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.service.AccesscardService;

@Service
//@Transcational
public class AccesscardServiceImpl implements AccesscardService {
	@Autowired
	AccesscardMapper accesscardmapper=null;
	@Override
	public AccesscardEntity register(AccesscardEntity accesscardEntity) throws Exception {
		return accesscardmapper.create(accesscardEntity);
	}
	@Override
	public void modify(AccesscardEntity accesscardEntity) throws Exception {
		accesscardmapper.update(accesscardEntity);
	}

	@Override
	public void delete(AccesscardEntity accesscardEntity) throws Exception {
		accesscardmapper.delete(accesscardEntity);
	}

	@Override
	public List<AccesscardEntity> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return accesscardmapper.selectListByAll();
	}

	@Override
	public AccesscardEntity getbyNo(double no) throws Exception {
		// TODO Auto-generated method stub
		return accesscardmapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return accesscardmapper.selectCountByAll();
	}

}
