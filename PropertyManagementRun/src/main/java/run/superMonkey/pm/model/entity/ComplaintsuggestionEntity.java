package run.superMonkey.pm.model.entity;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("complaintsuggestion")
public class ComplaintsuggestionEntity {
	private double complaintnoString;
	private Date complainttime;
	private String complaintcontent;
}
