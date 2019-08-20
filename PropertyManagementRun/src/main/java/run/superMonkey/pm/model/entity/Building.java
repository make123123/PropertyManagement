package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("Building")
@Data
public class Building implements Serializable{
	//序号
	private Double buildingno;
	//楼号
    private String bcode;
    //楼宇地址
    private String baddress;
    //楼宇朝向
    private String direction;
    //居民数
    private Double totalhome;
    //公建数
    private Double totalhouse; 
    //关联小区表
    private Area area = null;
    //关联建筑类型表
    private BuildingType buildingType = null;
  //关联房间表对象列表
    private List<Room> rooms = null;
}
