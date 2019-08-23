package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.VehicletimeEntity;


@Mapper
public interface VehicletimeMapper {
	public void create(VehicletimeEntity vehicletimeEntity) throws Exception;
	public void update(VehicletimeEntity vehicletimeEntity) throws Exception;
	public void delete(VehicletimeEntity vehicletimeEntity) throws Exception;


	public List<VehicletimeEntity> selectListByAll() throws Exception;
	//根据cardno取得单个客户资料
	public VehicletimeEntity  selectByNo(String no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
	//分页查找
	public List<VehicletimeEntity> selectListByPage(@Param("grantno")String grantno,@Param("cardtype")String cardtype,@Param("carno")String carno,@Param("start") int start,@Param("rows") int rows)throws Exception;
	//条件查找得到的数量
	public int selectCountByCondition(@Param("grantno")String grantno,@Param("cardtype")String cardtype,@Param("carno")String carno)throws Exception;
}
