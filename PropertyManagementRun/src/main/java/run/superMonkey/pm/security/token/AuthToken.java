package run.superMonkey.pm.security.token;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Access token  令牌
 * @author 彭俊豪（Peng Jun Hao）
 *
 */
@Data
public class AuthToken {
	/**
     * Access token.   令牌
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Expired in. (seconds)  过期时间
     */
    @JsonProperty("expired_in")
    private int expiredIn;

    /**
     * Refresh token.   刷新令牌
     */
    @JsonProperty("refresh_token")
    private String refreshToken;
}
