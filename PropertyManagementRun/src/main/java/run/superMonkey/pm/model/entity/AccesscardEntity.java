package run.superMonkey.pm.model.entity;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.io.Serializable;

@Data
@Alias("accesscard")
public class AccesscardEntity {
	private String cardno;
	private String carno;
	private double customerno;
	private String vechicletype;
	private String grantno;
	private Date granttime;
	private String cardtype;
	private Date overduetime;
}
