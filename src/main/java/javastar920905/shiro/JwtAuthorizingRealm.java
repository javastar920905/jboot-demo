package javastar920905.shiro;

/**
 * @author ouzhx  on ${date}
 * extends AuthorizingRealm
 */
public class JwtAuthorizingRealm  {
   /* @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtAuthenticationToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) token;
        String uid = (String) jwtToken.getPrincipal();

        // 此处判断 uid 是否存在，可以访问等操作

        return new SimpleAuthenticationInfo(uid, jwtToken.getCredentials(), this.getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 此处获取 uid 角色权限
        return null;
    }*/

}
