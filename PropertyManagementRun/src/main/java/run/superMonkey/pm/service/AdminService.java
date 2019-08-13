package run.superMonkey.pm.service;

import org.springframework.lang.NonNull;

import run.superMonkey.pm.model.paramter.LoginParam;
import run.superMonkey.pm.security.token.AuthToken;

/**
 * AdminServices
 * @author 彭俊豪Administrator
 *
 */
public interface AdminService {
	
	/**
     * Authenticates.
     *
     * @param loginParam login param must not be null
     * @return authentication token    身份验证令牌
     */
    @NonNull
    AuthToken authenticate(@NonNull LoginParam loginParam);
	
	
}
