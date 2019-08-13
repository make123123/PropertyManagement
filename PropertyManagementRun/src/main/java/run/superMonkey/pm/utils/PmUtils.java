package run.superMonkey.pm.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import ch.qos.logback.core.util.TimeUtil;

/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
public class PmUtils {
	
	
	@NonNull
	public static String timeFormat(long totalSeconds) {
		if(totalSeconds <= 0) {
			return "0 second";
		}
		//String,  StringBuilder, StringBuffer 区别  https://baijiahao.baidu.com/s?id=1629804867201303563&wfr=spider&for=pc
		StringBuilder timeBuilder = new StringBuilder();
		
		long hours = totalSeconds / 3600;
		long minutes = totalSeconds % 3600 / 60;
		long seconds = totalSeconds % 3600 % 60;
		
	    if (hours > 0) {
            if (StringUtils.isNotBlank(timeBuilder)) {
                timeBuilder.append(", ");
            }
            timeBuilder.append(pluralize(hours, "hour", "hours"));
        }

        if (minutes > 0) {
            if (StringUtils.isNotBlank(timeBuilder)) {
                timeBuilder.append(", ");
            }
            timeBuilder.append(pluralize(minutes, "minute", "minutes"));
        }

        if (seconds > 0) {
            if (StringUtils.isNotBlank(timeBuilder)) {
                timeBuilder.append(", ");
            }
            timeBuilder.append(pluralize(seconds, "second", "seconds"));
        }
		
		return timeBuilder.toString();
	}
	
	  /**
     * Pluralize the times label format.
     *
     * @param times       times
     * @param label       label
     * @param pluralLabel plural label
     * @return pluralized format
     */
    @NonNull
    public static String pluralize(long times, @NonNull String label, @NonNull String pluralLabel) {
        Assert.hasText(label, "Label must not be blank");
        Assert.hasText(pluralLabel, "Plural label must not be blank");

        if (times <= 0) {
            return "no " + pluralLabel;
        }

        if (times == 1) {
            return times + " " + label;
        }

        return times + " " + pluralLabel;
    }
    

}
