package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessEntity")

public class EmployessEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer empid;
    private Integer deptno;
    private String empname;
    private String sex;
    private Integer age;
    private Date joindate;
    private String job;
    private String mobile;
    private String tel;
    private String qq;
    private String wx;
}
