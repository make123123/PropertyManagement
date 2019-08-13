package run.superMonkey.pm.model.enums;

/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
public enum LogType implements ValueEnum<Integer>{
	
	PM_INITALIZED(0),   //初始化枚举
	POST_PUBLISHED(5),  //
    POST_EDITED(15),
    POST_DELETED(20),
    LOGGED_IN(25),     //登陆
    LOGGED_OUT(30),		//退出登陆
    LOGIN_FAILED(35),
    PASSWORD_UPDATED(40),
    PROFILE_UPDATED(45),
    SHEET_PUBLISHED(50),
    SHEET_EDITED(55),
    SHEET_DELETED(60);
	
	private final Integer value;
	
	LogType(Integer value) {
        this.value = value;
    }
	
	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
}
