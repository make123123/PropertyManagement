package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityDutyLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityDutyLogMapper {

    int deleteByPrimaryKey(Double dutyno);

    int insert(SecurityDutyLog record);

    int insertSelective(SecurityDutyLog record);

    SecurityDutyLog selectByPrimaryKey(Double dutyno);

    int updateByPrimaryKeySelective(SecurityDutyLog record);

    int updateByPrimaryKey(SecurityDutyLog record);
}