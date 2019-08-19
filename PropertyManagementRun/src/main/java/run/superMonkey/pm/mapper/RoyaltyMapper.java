package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.RoyaltyEntity;
@Mapper
public interface RoyaltyMapper {
	public void create(RoyaltyEntity royaltyEntity) throws Exception;
	public void update(RoyaltyEntity royaltyEntity) throws Exception;
	public void delete(RoyaltyEntity royaltyEntity) throws Exception;
	//所有客户资料
	public List<RoyaltyEntity> selectListByAll() throws Exception;
	//根据customerno取得单个客户资料
	public RoyaltyEntity  selectByNo(double no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
}
