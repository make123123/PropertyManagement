package run.superMonkey.pm.utils;

import java.util.Date;

import org.springframework.lang.NonNull;


/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
public class DateUtils {
	 private DateUtils() {
	    }

	    /**
	     * Gets current date.
	     *
	     * @return current date
	     */
	    @NonNull
	    public static Date now() {
	        return new Date();
	    }

	    /**
	     * Converts from date into a calendar instance.
	     *
	     * @param date date instance must not be null
	     * @return calendar instance
	     */
}
