package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessRpEntity")

public class EmployessRpEntity implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private Integer rpno;

    private Integer empid;

    private String rptype;

    private Double rpmoney;

    private Date rpdate;

    private String approvaldept;
}
