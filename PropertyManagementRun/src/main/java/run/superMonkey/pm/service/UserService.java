package run.superMonkey.pm.service;

import org.springframework.lang.NonNull;

import run.superMonkey.pm.model.entity.User;

public interface UserService {
		
	@NonNull
	User getByEmailOfNonNull(@NonNull String username);
	@NonNull
	User getByUsernameOfNonNull(@NonNull String username);

	void mustNotExpire(@NonNull User user);

}
