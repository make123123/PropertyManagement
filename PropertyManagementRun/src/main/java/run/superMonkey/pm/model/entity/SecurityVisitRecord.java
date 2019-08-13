package run.superMonkey.pm.model.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SecurityVisitRecord")
@Data
public class SecurityVisitRecord {
    private Double visitphoneno;

    private String visitname;

    private Date visittime;

    private Date leavetime;

    private Double visitroomno;

    
}