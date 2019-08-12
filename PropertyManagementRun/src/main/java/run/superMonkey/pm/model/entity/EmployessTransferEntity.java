package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessTransferEntity")
public class EmployessTransferEntity implements Serializable{
	private static final long serialVersionUID = 1L;
    
	  private Integer transferno;

	  private Integer empid;

	  private String jobbefore;

	  private String jobafter;

	  private Integer deptno;

	  private Date transferdate;

	  private Date approvaldate;
}
