package run.superMonkey.pm.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SecurityBoxRecord")
@Data
public class SecurityBoxRecord implements Serializable{
    private Double boxno;

    private String carno;

    private Date boxdate;

    private Double dutyno;

    private String visitname;

    
}