package javastar920905.listener;

import com.jfinal.core.Controller;
import io.jboot.component.shiro.JbootShiroInvokeListener;
import io.jboot.component.shiro.processer.AuthorizeResult;
import io.jboot.web.fixedinterceptor.FixedInvocation;

/**
 * @author ouzhx  on ${date}
 */
public class CustomShiroListener implements JbootShiroInvokeListener {
    @Override
    public void onInvokeBefore(FixedInvocation inv) {
        //do nothing
    }

    @Override
    public void onInvokeAfter(FixedInvocation inv, AuthorizeResult result) {
        if (result == null || result.isOk()) {
            inv.invoke();
            return;
        }

        int errorCode = result.getErrorCode();
        switch (errorCode) {
            case AuthorizeResult.ERROR_CODE_UNAUTHENTICATED:
                doProcessUnauthenticated(inv.getController());
                break;
            case AuthorizeResult.ERROR_CODE_UNAUTHORIZATION:
                doProcessuUnauthorization(inv.getController());
                break;
            default:
                inv.getController().renderError(404);
        }
    }

    public void doProcessUnauthenticated(Controller controller){
        // 处理认证失败
    }

    public void doProcessuUnauthorization(Controller controller){
        // 处理授权失败
    }
}
