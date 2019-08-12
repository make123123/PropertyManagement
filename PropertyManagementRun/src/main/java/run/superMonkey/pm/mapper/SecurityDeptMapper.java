package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityDept;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityDeptMapper {

    int deleteByPrimaryKey(Double securityno);

    int insert(SecurityDept record);

    int insertSelective(SecurityDept record);

    SecurityDept selectByPrimaryKey(Double securityno);

    int updateByPrimaryKeySelective(SecurityDept record);

    int updateByPrimaryKey(SecurityDept record);
}