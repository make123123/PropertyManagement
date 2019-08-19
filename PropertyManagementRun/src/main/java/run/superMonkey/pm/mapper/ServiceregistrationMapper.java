package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.ServiceregistrationEntity;

@Mapper
public interface ServiceregistrationMapper {
	public void create(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	public void update(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	public void delete(ServiceregistrationEntity serviceregistrationEntity) throws Exception;
	//所有客户资料
	public List<ServiceregistrationEntity> selectListByAll() throws Exception;
	//根据customerno取得单个客户资料
	public ServiceregistrationEntity selectByNo(double no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
}
