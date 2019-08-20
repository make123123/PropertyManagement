package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("BuildingType")
@Data
public class BuildingType implements Serializable{
	//类型编号
	private Double typeno;
	//类型名称(业主，租赁)
    private String typename;
    //关联楼宇表对象列表
    private List<Building> buildings = null;
}
