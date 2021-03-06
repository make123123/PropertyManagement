package run.superMonkey.pm.model.entity;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Alias("AccesscardEntity")
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
