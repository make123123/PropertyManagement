package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.VehiclearchiveEntity;


@Mapper
public interface VehiclearchiveMapper {
	public void create(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;
	public void update(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;
	public void delete(VehiclearchiveEntity vehiclearchiveEntity) throws Exception;


	public List<VehiclearchiveEntity> selectListByAll() throws Exception;
	//根据cardno取得单个客户资料
	public VehiclearchiveEntity  selectByNo(String no) throws Exception;
	//按条件 （车主，车牌，在库状态）分页查找
	public List<VehiclearchiveEntity> selectListByPage(@Param("carno")String carno,@Param("customerno")double customerno,@Param("state")String state,@Param("start")int start,@Param("rows")int rows)throws Exception;

	public int selectCountByCondition(@Param("carno")String carno,@Param("customerno")double customerno,@Param("state")String state)throws Exception;
	
}
