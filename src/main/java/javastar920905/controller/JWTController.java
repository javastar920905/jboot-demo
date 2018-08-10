package javastar920905.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * @author ouzhx  on ${date}
 */
@RequestMapping("jwt")
public class JWTController extends JbootController {

    /**
     * 登录 基于 jwt
     */
    public void postLogin(String loginName, String pwd) {
        //todo  此处判断用户名密码是否正确

        String userId = "userId"; //返回用户ID
        setJwtAttr("userId", userId); //构建jwt
        renderJson(); //返回成功
    }

    public void index() {
        setJwtAttr("key1", "test1");
        setJwtAttr("key2", "test2");

        //do your sth
    }

    public void show() {
        String value = getJwtPara("key1");
        // value : test1
    }

}
