package run.superMonkey.pm.model.entity;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("royalty")
public class RoyaltyEntity {
	private String registrationno;
	private double cost;
	private double tariff;
	private double profit;
}
