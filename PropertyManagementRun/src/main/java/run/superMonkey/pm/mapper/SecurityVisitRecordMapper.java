package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityVisitRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityVisitRecordMapper {

    int deleteByPrimaryKey(Double visitphoneno);

    int insert(SecurityVisitRecord record);

    int insertSelective(SecurityVisitRecord record);

    SecurityVisitRecord selectByPrimaryKey(Double visitphoneno);

    int updateByPrimaryKeySelective(SecurityVisitRecord record);

    int updateByPrimaryKey(SecurityVisitRecord record);
}