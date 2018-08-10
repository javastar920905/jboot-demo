package javastar920905.shiro;


/**
 * @author ouzhx  on ${date}
 * implements AuthenticationToken
 */
public class JwtAuthenticationToken {
    /**
     * 用户id
     */
    private String userId;
    /**
     * token
     */
    private String token;

    // @Override
    public Object getPrincipal() {
        return userId;
    }

    // @Override
    public Object getCredentials() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
