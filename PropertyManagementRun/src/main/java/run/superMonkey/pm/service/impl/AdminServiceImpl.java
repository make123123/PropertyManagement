package run.superMonkey.pm.service.impl;

import javax.validation.Valid;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;
import run.superMonkey.pm.event.LogEvent;
import run.superMonkey.pm.exception.BadRequestException;
import run.superMonkey.pm.exception.NotFoundException;
import run.superMonkey.pm.model.entity.User;
import run.superMonkey.pm.model.enums.LogType;
import run.superMonkey.pm.model.paramter.LoginParam;
import run.superMonkey.pm.security.token.AuthToken;
import run.superMonkey.pm.service.AdminService;
import run.superMonkey.pm.service.UserService;

/**
 * 
 * @author 彭俊豪（Peng Jun Hao）
 *
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
	
	private ApplicationEventPublisher eventPublisher;
	
	private UserService userSerive;
	
	/**
	 * Login validator
	 */
	public AuthToken authenticate(LoginParam loginParam) {
		Assert.notNull(loginParam, "Login param must not be null！！");
		
		String username = loginParam.getUsername();
		
		String errorMessage = "用户名或密码不正确";
		
		final User user;
		
		try {
			// Get user by username or email
			user = Validator.isEmail(username) ?
					userSerive.getByEmailOfNonNull(username) : userSerive.getByUsernameOfNonNull(username);
		}catch(NotFoundException e) {
			log.error("Failed to find user by name: " + username, e);
			eventPublisher.publishEvent(new LogEvent(this, loginParam.getUsername(), 
					LogType.LOGIN_FAILED, loginParam.getUsername()));

            throw new BadRequestException(errorMessage);
		}
		userSerive.mustNotExpire(user);
		
		
				
		return null;
	}
	

}
