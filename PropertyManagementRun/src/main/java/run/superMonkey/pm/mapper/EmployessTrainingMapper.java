package run.superMonkey.pm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.model.entity.EmployessTrainingEntity;

@Mapper
public interface EmployessTrainingMapper {
	//增
    public void insertSelective(EmployessTrainingEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer empid)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessTrainingEntity record)throws Exception;
    //查
    public EmployessTrainingEntity selectByPrimaryKey(int empid)throws Exception;
	public List<EmployessTrainingEntity> selectListByAll()throws Exception; 
	public List<EmployessTrainingEntity> selectListByPage(@Param("deptno")int deptno,@Param("sex")String sex,@Param("joindate")Date joindate,@Param("start") int start,@Param("rows") int rows)throws Exception;
	public int selectCountByCondition(@Param("deptno")int deptno,@Param("sex")String sex,@Param("joindate")Date joindate)throws Exception;
}
