package run.superMonkey.pm.model.entity;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("VehicletimeEntity")
public class VehicletimeEntity {
	private String carno;
	private double customerno;
	private String vechicletype;
	private String parkinglot;
	private String state;
}
