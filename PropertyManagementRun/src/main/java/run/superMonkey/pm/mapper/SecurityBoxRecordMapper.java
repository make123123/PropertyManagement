package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityBoxRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityBoxRecordMapper {

    int deleteByPrimaryKey(Double boxno);

    int insert(SecurityBoxRecord record);

    int insertSelective(SecurityBoxRecord record);

    SecurityBoxRecord selectByPrimaryKey(Double boxno);

    int updateByPrimaryKeySelective(SecurityBoxRecord record);

    int updateByPrimaryKey(SecurityBoxRecord record);
}