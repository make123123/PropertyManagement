package run.superMonkey.pm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.SecurityBoxRecordMapper;
import run.superMonkey.pm.model.entity.SecurityBoxRecord;
import run.superMonkey.pm.service.SecurityBoxRecordService;

@Service
public class SecurityBoxRecordServiceImpl implements SecurityBoxRecordService {
	
	@Autowired
	SecurityBoxRecordMapper sb;
	
	
	
	@Override
	public void register(SecurityBoxRecord securityBoxRecord) throws Exception {
		sb.insert(securityBoxRecord);

	}

	@Override
	public void update(SecurityBoxRecord securityBoxRecord) throws Exception {
		sb.updateByVisitName(securityBoxRecord);
	}

	@Override
	public void delete(String visitname) throws Exception {
		sb.deleteByVisitName(visitname);
	}

	@Override
	public SecurityBoxRecord getByPrimaryKey(Double boxno) throws Exception {
		return sb.selectByPrimaryKey(boxno);
	}
	@Override
	public SecurityBoxRecord getByVisitName(String visitname) throws Exception {
		return sb.selectByVisitName(visitname);
	}

	@Override
	public List<SecurityBoxRecord> selectListByAll() throws Exception {
		return sb.selectListByAll();
	}

	@Override
	public int getCountByConditionWithBoxnoWithPage(Date boxdate, Double dutyno) throws Exception {
		return sb.selectCountByCondition(boxdate, dutyno);
	}

	@Override
	public int getPageCountByConditionWithBoxnoWithPage(Date boxdate, Double dutyno, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByConditionWithBoxnoWithPage(boxdate, dutyno);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	
	@Override
	public List<SecurityBoxRecord> getListByConditionWithBoxWithPage(Date boxdate, Double dutyno, int rows, int page)
			throws Exception {
		
		return sb.selectListByALLWithBoxAndDutylogWithPage(boxdate, dutyno,rows*(page-1), rows);
	}
	
	//检查岗亭是否合法
	@Override
	public boolean checkIdExist(Double boxno) throws Exception {
		boolean result=false;
		if(sb.selectCountByBoxNo(boxno)>0) {
			result=true;
		}
		return result;
	}


}
