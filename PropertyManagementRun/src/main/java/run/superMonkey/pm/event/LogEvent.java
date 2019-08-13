package run.superMonkey.pm.event;

import org.springframework.context.ApplicationEvent;

import run.superMonkey.pm.model.enums.LogType;
import run.superMonkey.pm.model.paramter.LogParam;
import run.superMonkey.pm.utils.ValidationUtils;

public class LogEvent extends ApplicationEvent {
	
	private final LogParam logParam;
	
	
	/**
	 * Create a new ApplicationEvent
	 * @param source  the object on which the event initially occurred (never {@code null})
	 * @param logParam  log param
	 */
	public LogEvent(Object source, LogParam logParam) {
		super(source);
		// Validate the log param
        ValidationUtils.validate(logParam);

        this.logParam = logParam;
		
	}
	
	public LogEvent(Object source, String logKey, LogType logType, String content) {
        this(source, new LogParam(logKey, logType, content));
        
        
    }
	
	public LogParam getLogParam() {
        return logParam;
    }

}
