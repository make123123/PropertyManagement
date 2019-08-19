package run.superMonkey.pm.model.entity;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("bottomsheet")
public class BottomsheetEntity {
	private String registrationno;
	private String registrationlocation;
	private String constructionunit;
	private Date contructiontime;
	private String remark;
}
