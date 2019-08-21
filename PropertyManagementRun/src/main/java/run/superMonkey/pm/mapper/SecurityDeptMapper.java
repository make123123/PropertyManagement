package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityDept;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface SecurityDeptMapper {

    int deleteByPrimaryKey(Integer securityno);

    int insert(SecurityDept record);

    int insertSelective(SecurityDept record);
    
    List<SecurityDept> selectListByAll();
    
    SecurityDept selectByPrimaryKey(Integer securityno);


    int updateByPrimaryKeySelective(SecurityDept record);

    int updateByPrimaryKey(SecurityDept record);
    
    //根据综合检索条件取得员工个数
    int selectCountByCondition(@Param("securitysex") String securitysex,@Param("securityage") Integer securityage) ;
    //根据综合检索条件取得员工列表，取得关联的部门，不取关联的爱好列表，分页模式
    List<SecurityDept> selectListByALLWithSecurityDeptWithPage(@Param("securitysex") String securitysex,@Param("securityage") Integer securityage,@Param("start") int start,@Param("rows") int rows);
    
    //检查指定的securityno的员工个数，用于验证员工securityno是否存在
    int selectCountByNo(@Param("securityno") String securityno);

    
    
}