package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessEvaluationEntity")

public class EmployessEvaluationEntity implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
    private Integer evaluationno;

	private Integer empid;

	private String evaluationgrade;

	private Date evaluationdate;

}
