package javastar920905.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.limitation.LimitRenderType;
import io.jboot.web.limitation.annotation.EnablePerIpLimit;
import io.jboot.web.limitation.annotation.EnablePerUserLimit;

/**
 * @author ouzhx  on ${date}
 * <p>
 * 限流和流量控制
 *
 *
 @EnableRequestLimit(rate = 1)//所有的请求，每1秒钟只能访问一次
 @EnableConcurrencyLimit(rate = 1)//所有的请求，并发量为1个
 @EnablePerIpLimit(rate = 0.2)//每个IP地址，每5秒钟只能访问一次
 //所有的请求，每1秒钟只能访问一次;被限制的请求，自动跳转到 /limitation/request2
 @EnableRequestLimit(rate = 1, renderType = LimitRenderType.REDIRECT, renderContent = "/limitation/request2")
 @EnablePerUserLimit(rate = 0.2, renderType = LimitRenderType.TEXT, renderContent = "被限制啦")//每个用户，每5秒钟只能访问一次

 */
@RequestMapping("limitation")
public class LimitController extends JbootController {
    @EnablePerIpLimit(rate = 0.2,renderContent = "每个IP地址，每5秒钟只能访问一次")
    public void index() {
        renderText("limit test");
    }

    @EnablePerUserLimit(rate = 0.2, renderType = LimitRenderType.TEXT, renderContent = "每个用户，每5秒钟只能访问一次")
    public void websocket(){
        render("view/websocket.html");
    }
}
