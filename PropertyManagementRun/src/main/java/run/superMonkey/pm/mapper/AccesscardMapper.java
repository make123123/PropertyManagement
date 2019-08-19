package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.AccesscardEntity;
@Mapper
public interface AccesscardMapper {
	public AccesscardEntity create(AccesscardEntity accesscardEntity) throws Exception;
	public void update(AccesscardEntity accesscardEntity) throws Exception;
	public void delete(AccesscardEntity accesscardEntity) throws Exception;
	//所有客户资料
	public List<AccesscardEntity> selectListByAll() throws Exception;
	//根据customerno取得单个客户资料
	public AccesscardEntity  selectByNo(double no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
}
