package run.superMonkey.pm.model.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SecurityBoxRecord")
@Data
public class SecurityBoxRecord {
    private Double boxno;

    private String carno;

    private Date boxdate;

    private Double dutyno;

    private String visitname;

    
}