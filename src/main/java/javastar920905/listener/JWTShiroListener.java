package javastar920905.listener;

import io.jboot.component.shiro.JbootShiroInvokeListener;
import io.jboot.component.shiro.processer.AuthorizeResult;
import io.jboot.web.fixedinterceptor.FixedInvocation;
import javastar920905.shiro.JwtAuthenticationToken;

/**
 * @author ouzhx  on ${date}
 */
public class JWTShiroListener implements JbootShiroInvokeListener {
    @Override
    public void onInvokeBefore(FixedInvocation inv) {
        String userId = null;//String.valueOf(inv.getController.getJwtPara(USER_ID));

        JwtAuthenticationToken token = new JwtAuthenticationToken();
        token.setUserId(userId);
        token.setToken(userId);

       /* Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return subject;*/

    }

    @Override
    public void onInvokeAfter(FixedInvocation inv, AuthorizeResult result) {

    }
}
