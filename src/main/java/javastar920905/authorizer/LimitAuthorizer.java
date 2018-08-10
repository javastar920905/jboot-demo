package javastar920905.authorizer;

import com.jfinal.core.Controller;
import io.jboot.web.limitation.web.Authorizer;

/**
 * @author ouzhx  on ${date}
 */
public class LimitAuthorizer  implements Authorizer {
    @Override
    public boolean onAuthorize(Controller controller) {
        //限流功能对系统至关重要，为了防止恶意用户猜出限流API对系统进行恶意操作，因此Jboot提供了限流API的权限设置功能
        return true;
    }
}
