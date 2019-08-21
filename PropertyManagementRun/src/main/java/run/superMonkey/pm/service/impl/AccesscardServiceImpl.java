package run.superMonkey.pm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import run.superMonkey.pm.mapper.AccesscardMapper;
import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.service.AccesscardService;

@Service
//@Transactional
public class AccesscardServiceImpl implements AccesscardService {
	@Autowired
	private AccesscardMapper accesscardMapper=null;
	@Override
	public AccesscardEntity register(AccesscardEntity accesscardEntity) throws Exception {
		 return accesscardMapper.create(accesscardEntity);
	}
	@Override
	public void modify(AccesscardEntity accesscardEntity) throws Exception {
		accesscardMapper.update(accesscardEntity);
	}

	@Override
	public void delete(AccesscardEntity accesscardEntity) throws Exception {
		accesscardMapper.delete(accesscardEntity);
	}

	@Override
	public List<AccesscardEntity> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return accesscardMapper.selectListByAll();
	}

	@Override
	public AccesscardEntity getbyNo(String no) throws Exception {
		// TODO Auto-generated method stub
		return accesscardMapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return accesscardMapper.selectCountByAll();
	}
	@Override
	public List<AccesscardEntity> getListByPage(String grantno,String carno,String cardtype,int page,int rows) throws Exception{
		return accesscardMapper.selectListByPage(grantno,carno,cardtype,rows*(page-1), rows);
	}

}
