package run.superMonkey.pm.service.impl;

import java.util.Date;

import java.util.concurrent.TimeUnit;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import run.superMonkey.pm.exception.ForbiddenException;
import run.superMonkey.pm.model.entity.User;
import run.superMonkey.pm.service.UserService;
import run.superMonkey.pm.utils.DateUtils;
import run.superMonkey.pm.utils.PmUtils;

/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getByEmailOfNonNull(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsernameOfNonNull(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mustNotExpire(User user) {
		Assert.notNull(user, "User must not be null");
		
		Date now = DateUtils.now();
		//Date1.after(Date2),当Date1大于Date2时，返回TRUE，当小于等于时，返回false；
		//即Date2比Date1小的true/false，当Date2日期比Date1小的时候为true，否则为false
		//Date1.before(Date2)，当Date1小于Date2时，返回TRUE，当大于等于时，返回false；
		if(user.getExpireTime() != null && user.getExpireTime().after(now)) {
			//TimeUnit的使用  https://www.jianshu.com/p/4ab62e4a328f
			long seconds = TimeUnit.MILLISECONDS.toSeconds(user.getExpireTime().getTime() - now.getTime());
			//experid
			throw new ForbiddenException("账号已经被停用，请"+ PmUtils.timeFormat(seconds) + " 后重试").setErrorData(seconds);
		}
		
	}
	
}
