package run.superMonkey.pm.event;

import java.util.Date;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogEventListner {


	
	@EventListener
	@Async
	public void onApplicationEvent(LogEvent evet) {
		log.debug("监听到了事件"+evet.getLogParam().getContent()+new Date());
	}
}
