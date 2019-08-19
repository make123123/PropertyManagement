package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.ComplaintsuggestionEntity;

@Mapper
public interface ComplaintsuggestionMapper {
	public void create(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	public void update(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	public void delete(ComplaintsuggestionEntity complaintsuggestionEntity) throws Exception;
	//所有客户资料
	public List<ComplaintsuggestionEntity> selectListByAll() throws Exception;
	//根据customerno取得单个客户资料
	public ComplaintsuggestionEntity selectByNo(double no) throws Exception;
	//取得客户个数
	public int selectCountByAll() throws Exception;
}
