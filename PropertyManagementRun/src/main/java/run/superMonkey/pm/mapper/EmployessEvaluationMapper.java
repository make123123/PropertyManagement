package run.superMonkey.pm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.EmployessEvaluationEntity;


@Mapper
public interface EmployessEvaluationMapper {
	//增
    public void insertSelective(EmployessEvaluationEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer evaluationno)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessEvaluationEntity record)throws Exception;
    //查
    public EmployessEvaluationEntity selectByPrimaryKey(int evaluationno)throws Exception;
	public List<EmployessEvaluationEntity> selectListByAll()throws Exception; 
	public List<EmployessEvaluationEntity> selectListByPage(@Param("empid")int empid,@Param("evaluationgrade")String evaluationgrade,@Param("evaluationdate")Date evaluationdate,@Param("start") int start,@Param("rows") int rows)throws Exception;
	public int selectCountByCondition(@Param("empid")int empid,@Param("evaluationgrade")String evaluationgrade,@Param("evaluationdate")Date evaluationdate)throws Exception;
	public int checkDate(@Param("empid")int empid,@Param("evaluationdate")Date evaluationdate)throws Exception;
}
