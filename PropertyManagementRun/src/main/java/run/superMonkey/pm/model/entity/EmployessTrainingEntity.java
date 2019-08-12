package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessTrainingEntity")

public class EmployessTrainingEntity implements Serializable{
	    private static final long serialVersionUID = 1L;

		private Integer trainingno;

	    private Integer empid;

	    private String trainingcontent;

	    private Date trainingdate;

}
