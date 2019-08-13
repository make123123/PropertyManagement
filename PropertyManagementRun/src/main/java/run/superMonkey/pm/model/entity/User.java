package run.superMonkey.pm.model.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	
	//primary
	private Integer id;
	
	
	private String password;
	
	private String username;
	
	
	private String userStatus;
	
	private String email;
	
	private String nickname;
	//停用时间
	private Date expireTime;
	//头像
	private String avatar;

    private String description;
}
