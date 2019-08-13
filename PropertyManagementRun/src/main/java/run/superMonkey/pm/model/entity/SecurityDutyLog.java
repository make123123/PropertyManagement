package run.superMonkey.pm.model.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SecurityDutyLog")
@Data
public class SecurityDutyLog {
    private Double dutyno;

    private String dutyname;

    private Date dutydate;
    
}