package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.ServiceregistrationMapper;
import run.superMonkey.pm.model.entity.ServiceregistrationEntity;
import run.superMonkey.pm.service.ServiceregistrationService;
@Service
public class ServiceregistrationServiceImpl implements ServiceregistrationService {
	@Autowired
	ServiceregistrationMapper serviceregistrationmapper=null;
	@Override
	public void register(ServiceregistrationEntity serviceregistrationEntity) throws Exception {
		serviceregistrationmapper.create(serviceregistrationEntity);
	}

	@Override
	public void modify(ServiceregistrationEntity serviceregistrationEntity) throws Exception {
		serviceregistrationmapper.update(serviceregistrationEntity);
	}

	@Override
	public void delete(ServiceregistrationEntity serviceregistrationEntity) throws Exception {
		serviceregistrationmapper.delete(serviceregistrationEntity);
	}

	@Override
	public List<ServiceregistrationEntity> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return serviceregistrationmapper.selectListByAll();
	}

	@Override
	public ServiceregistrationEntity getbyNo(double no) throws Exception {
		// TODO Auto-generated method stub
		return serviceregistrationmapper.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return serviceregistrationmapper.selectCountByAll();
	}

}
