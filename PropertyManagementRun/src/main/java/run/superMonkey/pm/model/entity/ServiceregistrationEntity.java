package run.superMonkey.pm.model.entity;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("ServiceRegistration")
public class ServiceregistrationEntity {
	private String registrationno;
	private String registrationtype;
	private String registrationproject;
	private double customerno;
	private Date registrationtime;
	private String registrationlacation;
	private double registrationmoney;
}
