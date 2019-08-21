package run.superMonkey.pm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import run.superMonkey.pm.model.entity.EmployessEntity;

@Mapper
public interface EmployessMapper {
	//增
    public void insertSelective(EmployessEntity record)throws Exception;
    //删
    public void deleteByPrimaryKey(Integer empid)throws Exception;
    //改
    public void updateByPrimaryKeySelective(EmployessEntity record)throws Exception;
    //查
    public EmployessEntity selectByPrimaryKey(int empid)throws Exception;
	public List<EmployessEntity> selectListByAll()throws Exception; 
	public List<EmployessEntity> selectListByPage(@Param("deptno")int deptno,@Param("sex")String sex,@Param("joindate")Date joindate,@Param("start") int start,@Param("rows") int rows)throws Exception;
	public int selectCountByCondition(@Param("deptno")int deptno,@Param("sex")String sex,@Param("joindate")Date joindate)throws Exception;
}
