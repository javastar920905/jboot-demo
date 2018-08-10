package javastar920905.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.limitation.LimitRenderType;
import io.jboot.web.limitation.annotation.EnablePerUserLimit;

/**
 * @author ouzhx  on ${date}
 */
@RequestMapping("shiro")
public class ShiroController extends JbootController {
/*    @RequiresPermissions("permission1")
    @RequiresRoles("role1")
    @RequiresRoles(value = {"role1","role2"},logical=Logincal.AND)
    @RequiresUser*/
    public void index() {
        renderText("hello jboot");
    }

//    @RequiresPermissions(value={"permission1","permission2"},logical=Logincal.AND)
//    @RequiresGuest
//    @RequiresAuthentication
    public void websocket(){
        render("view/websocket.html");
    }
}
