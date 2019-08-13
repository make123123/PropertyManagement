package run.superMonkey.pm.model.entity;

import lombok.Data;
import run.superMonkey.pm.model.enums.LogType;

/**
 * Log entity
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
@Data
public class Log {
	
	private Long id;
	
	private String logkey;
	
	private LogType type;
	
	private String content;
	
	private String ipAddress;
}
