package run.superMonkey.pm.model.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployessDeptEntity")
public class EmployessDeptEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private Integer deptno;

	private String deptname;
}
