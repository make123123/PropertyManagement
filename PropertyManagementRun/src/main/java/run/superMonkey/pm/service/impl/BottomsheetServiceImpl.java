package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.BottomsheetMapper;
import run.superMonkey.pm.model.entity.BottomsheetEntity;
import run.superMonkey.pm.service.BottomsheetService;
@Service
public class BottomsheetServiceImpl implements BottomsheetService {
	@Autowired
	BottomsheetMapper bottomsheetmapper=null;
	@Override
	public void register(BottomsheetEntity bottomsheetEntity) throws Exception {
		bottomsheetmapper.create(bottomsheetEntity);
	}

	@Override
	public void modify(BottomsheetEntity bottomsheetEntity) throws Exception {
		bottomsheetmapper.update(bottomsheetEntity);
	}

	@Override
	public void delete(BottomsheetEntity bottomsheetEntity) throws Exception {
		bottomsheetmapper.delete(bottomsheetEntity);
	}

	@Override
	public List<BottomsheetEntity> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return bottomsheetmapper.selectListByAll();
	}

	@Override
	public BottomsheetEntity getbyNo(double no) throws Exception {
		// TODO Auto-generated method stub
		return bottomsheetmapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return bottomsheetmapper.selectCountByAll();
	}

}
