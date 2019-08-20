package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("HouseType")
@Data
public class HouseType implements Serializable{
	//类型编号
	private Double typeno;
	//类型名称
    private String typename; 
    //关联房间表对象列表
    private List<Room> rooms = null;
}
