package run.superMonkey.pm.model.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Alias("Room")
@Data
public class Room implements Serializable{
	//房间编号
	private Double roomno;
	//单元
    private String departmentcode;
    //楼层
    private String floor;
    //房间号
    private String roomcode;
    //使用面积
    private Double buildingarea;
    //缴费面积
    private Double feearea;
    //房间状态(空闲/入住)
    private String roomstatus;
    //房间类型(room 住宅)
    private String roomtype;
    //关联户型表对象
    private HouseType housetype = null;
    //关联楼宇表对象
    private Building building = null;
}
