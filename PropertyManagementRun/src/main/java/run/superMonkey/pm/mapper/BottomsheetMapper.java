package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.BottomsheetEntity;
@Mapper
public interface BottomsheetMapper {
	public void create(BottomsheetEntity bottomsheetEntity) throws Exception;
	public void update(BottomsheetEntity bottomsheetEntity) throws Exception;
	public void delete(BottomsheetEntity bottomsheetEntity) throws Exception;
	//所有客户资料
	public List<BottomsheetEntity> selectListByAll() throws Exception;
	//根据customerno取得单个客户资料
	public BottomsheetEntity selectByNo(double no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
}
