package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Alias("Area")
@Data
public class Area implements Serializable{
	//小区编号
	private Double areano;
	//小区名称
	private String areaname;
	//小区地址
    private String aaddress;
    //开发商
	private String developer;
	//总建筑面积
	private Double totalbuidingarea;
	//总使用面积
	private Double totalusearea;
	//车位面积
	private Double totalpackarea;
	//总居民数
	private Double totalhome;
	//总公建数
	private Double totalhouse;
	//车位数
	private Double totalpack;
	@JsonIgnore
	//关联楼宇表对象列表
	private List<Building> buildings = null;
    
}
