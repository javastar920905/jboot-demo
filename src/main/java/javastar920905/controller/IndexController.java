package javastar920905.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.limitation.LimitRenderType;
import io.jboot.web.limitation.annotation.EnablePerUserLimit;
import javastar920905.service.UserService;

import javax.inject.Inject;

/**
 * @author ouzhx  on ${date}
 * JbootController新增的普通方法：
 * <p>
 * isAjaxRequest()
 * 是否是ajax请求
 * isMultipartRequest()
 * 是否是带有文件上传功能的请求
 * getReferer()
 * 获取来源网址器
 * getIPAddress()
 * 获取用户的IP地址，这个决定于浏览器，同时做nginx等转发的时候要做好配置
 * getUserAgent()
 * 获取http头的useragent
 * getBaseUrl()
 * 获取当前域名
 * getUploadFilesMap()
 * 获取当前上传的所有文件
 * <p>
 * <p>
 * 新增关于FlashMessage的方法：
 * 方法调用
 * 描述
 * setFlashAttr()
 * 设置 FlashMessage 的 key 和 value
 * setFlashMap()
 * 把整个 map的key和value 设置到 FlashMessage
 * getFlashAttr()
 * 获取 已经设置进去的FlashMessage 信息
 * getFlashAttrs()
 * 获取 所有已经设置进去的 FlashMessage 信息
 * FlashMessage 是一种特殊的 attribute，用法和 setAttr 一样，唯一不同的是 setAttr 是用于当前页面渲染，而 setFlashAttr 是用于对 redirect 之后的页面进行渲染。
 */
@RequestMapping("/")
public class IndexController extends JbootController {
    @Inject
    private UserService userService;

    public void index() {
        renderText("hello jboot");
    }

    @EnablePerUserLimit(rate = 0.2, renderType = LimitRenderType.TEXT, renderContent = "被限制啦")////每个用户，每5秒钟只能访问一次
    public void websocket() {
        render("view/websocket.html");
    }
}
