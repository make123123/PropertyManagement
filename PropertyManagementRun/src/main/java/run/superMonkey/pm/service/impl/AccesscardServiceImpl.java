package run.superMonkey.pm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.AccesscardMapper;
import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.service.AccesscardService;

@Service
//@Transactional
public class AccesscardServiceImpl implements AccesscardService {
	@Autowired
	private AccesscardMapper accesscardMapper=null;
	@Override
	public void register(AccesscardEntity accesscardEntity) throws Exception {
		accesscardMapper.create(accesscardEntity);
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
	public List<AccesscardEntity> getListByPage(String grantno,String cardtype,String carno,int page,int rows) throws Exception{
		return accesscardMapper.selectListByPage(grantno,cardtype,carno,rows*(page-1), rows);
	}
	@Override
	public int getCountByCondition(String grantno,String cardtype,String carno)throws Exception{
		return accesscardMapper.selectCountByCondition(grantno, cardtype, carno);
	}
	@Override
	public int getPageCountByCondition(String grantno,String cardtype,String carno, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(grantno,cardtype,carno);
		if(count%rows==0) {
			pageCount=count/rows;
		}else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	@Override
	public boolean checkIdExist(String cardno) throws Exception {
		boolean res=false;
		if(accesscardMapper.selectByNo(cardno)!=null) res=true;
		return res;
	}
}
