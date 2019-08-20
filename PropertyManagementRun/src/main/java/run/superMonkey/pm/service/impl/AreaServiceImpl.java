package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.AreaMapper;
import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService{
	@Autowired
	private AreaMapper areaMapper=null;
	@Override
	public void register(Area area) throws Exception {
		areaMapper.create(area);
	}

	@Override
	public void modify(Area area) throws Exception {
		areaMapper.update(area);
	}

	@Override
	public void delete(Area area) throws Exception {
		areaMapper.delete(area);
	}


	@Override
	public List<Area> getListByAllWithoutPage() throws Exception {
		return areaMapper.selectListByAllWithoutPage();
	}

	@Override
	public List<Area> getListByAllWithPage(int rows, int page) throws Exception {
		return areaMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public Area getByAreano(Double areano) throws Exception {
		Area am=areaMapper.selectByAreanoWithBuilding(areano);
		
		return am;
	}

	@Override
	public int getCount(String areaname, String aaddress, String developer) throws Exception {
		return areaMapper.selectCountByCondition(areaname, aaddress, developer);
	}

	@Override
	public int getPageCount(String areaname, String aaddress, String developer,int rows) throws Exception {
		int pageCount=0;
		int count=this.getCount(areaname, aaddress, developer);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<Area> getListByConditionWithPage(String areaname, String aaddress, String developer, int rows, int page)
			throws Exception {
		return areaMapper.selectListByConditionWithPage(areaname, aaddress, developer, rows*(page-1), rows);
	}

	@Override
	public boolean checkAreanoExist(Double areano) throws Exception {
		boolean result=false;
		if(areaMapper.selectCountByAreano(areano)>0) {
			result=true;
		}
		return result;
	}

}
