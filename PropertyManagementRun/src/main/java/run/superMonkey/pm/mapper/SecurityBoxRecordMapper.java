package run.superMonkey.pm.mapper;

import run.superMonkey.pm.model.entity.SecurityBoxRecord;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityBoxRecordMapper {

    int deleteByPrimaryKey(Double boxno);

    int deleteByVisitName(String visitname);

    int insert(SecurityBoxRecord record);

    int insertSelective(SecurityBoxRecord record);

    SecurityBoxRecord selectByPrimaryKey(Double boxno);

    SecurityBoxRecord selectByVisitName(String visitname);

    int updateByPrimaryKeySelective(SecurityBoxRecord record);

    int updateByPrimaryKey(SecurityBoxRecord record);
    
    int updateByVisitName(SecurityBoxRecord record);
    
    List<SecurityBoxRecord> selectListByAll();
    
    //根据综合检索条件取得员工个数
    int selectCountByCondition(@Param("boxdate") Date boxdate,@Param("dutyno") Double dutyno) ;
    //根据综合检索条件取得员工列表，取得关联的部门，不取关联的爱好列表，分页模式
    List<SecurityBoxRecord> selectListByALLWithBoxAndDutylogWithPage(@Param("boxdate") Date boxdate,@Param("dutyno") Double dutyno,@Param("start") int start,@Param("rows") int rows);
    
    //检查指定的securityno的员工个数，用于验证员工securityno是否存在
    int selectCountByBoxNo(@Param("boxno") Double boxno);
    
    
}