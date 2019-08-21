package run.superMonkey.pm.model.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SecurityDept")
@Data
public class SecurityDept implements Serializable{
    private Integer securityno;

    private String securityname;
    
    
    private String securitysex;

    private Integer securityage;
}