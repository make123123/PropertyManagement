package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityDept;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SecurityDeptMapper {

    int deleteByPrimaryKey(Integer securityno);

    int insert(SecurityDept record);

    int insertSelective(SecurityDept record);

    SecurityDept selectByPrimaryKey(Integer securityno);

    int updateByPrimaryKeySelective(SecurityDept record);

    int updateByPrimaryKey(SecurityDept record);
}