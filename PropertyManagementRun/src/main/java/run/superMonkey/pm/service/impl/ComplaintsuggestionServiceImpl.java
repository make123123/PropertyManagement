package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import run.superMonkey.pm.mapper.ComplaintsuggestionMapper;
import run.superMonkey.pm.model.entity.ComplaintsuggestionEntity;
import run.superMonkey.pm.service.ComplaintsuggestionService;

public class ComplaintsuggestionServiceImpl implements ComplaintsuggestionService {
	@Autowired
	ComplaintsuggestionMapper complaintsuggestionermapper=null;
	@Override
	public void register(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception {
		complaintsuggestionermapper.create(complaintsuggestionEntity);
	}

	@Override
	public void modify(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception {
		complaintsuggestionermapper.update(complaintsuggestionEntity);
	}

	@Override
	public void delete(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception {
		complaintsuggestionermapper.delete(complaintsuggestionEntity);
	}

	@Override
	public List<ComplaintsuggestionEntity> getListByAll() throws Exception {
		return complaintsuggestionermapper.selectListByAll();
	}

	@Override
	public ComplaintsuggestionEntity getbyNo(double no) throws Exception {
		// TODO Auto-generated method stub
		return complaintsuggestionermapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return complaintsuggestionermapper.selectCountByAll();
	}
}
