# jboot 使用demo
Jboot，专为大型分布式项目和微服务而生。
[github 主页](https://github.com/java-frame/jboot/blob/master/README-ZH.md)
[参考文档](https://github.com/java-frame/jboot/blob/master/DOC.md)
[请参考JFinal的文档](http://download.jfinal.com/download/3.2/jfinal-3.2-manual.pdf)
# 快速入门
- 1.新建maven项目
- 2 添加jboot依赖

    <dependency>
        <groupId>io.jboot</groupId>
        <artifactId>jboot</artifactId>
        <version>1.6.3</version>
    </dependency>
    
    刷新依赖 mvn clean install
- 3 查看参考文档 编码

# 开发规范说明
- 在Jboot应用中，所有的控制器都应该继承至JbootController
- 在 Controller 之中定义的 public 方法称为 Action。Action 是请求的最小单位。
    Action 方法 必须在 Controller 中定义，且必须是 public 可见性。
    每个Action对应一个URL地址的映射
- getModel 用来接收页面表单域传递过来的 model 对象

# render 介绍
渲染器，负责把内容输出到浏览器，在Controller中，提供了如下一些列render方法
-- 视图
render(”test.html”) 渲染名为 test.html 的视图，该视图的全路径为”/path/test.html”
renderTemplate(”test.html”) 渲染名为 test.html 的视图，该视图的全路径为”/other_path/test.html”，
    即当参数以”/”开头时将采用绝对路径。
renderFreeMarker(”test.html”) 渲 染 名 为 test.html 的视图 ， 且 视图类型为FreeMarker。
renderJsp(”test.jsp”) 渲染名为 test.jsp 的视图，且视图类型为 Jsp。
renderVelocity(“test.html”) 渲染名为 test.html 的视图，且视图类型为 Velocity。
-- json
renderJson() 将所有通过 Controller.setAttr(String, Object)设置的变量转换成 json 数据并渲染。
renderJson(“users”, userList) 以”users”为根，仅将 userList 中的数据转换成 json数据并渲染。
renderJson(user) 将 user 对象转换成 json 数据并渲染。
renderJson(“{\”age\”:18}” ) 直接渲染 json 字符串。
renderJson(new String[]{“user”, “blog”}) 仅将 setAttr(“user”, user)与 setAttr(“blog”, blog)设置的属性转换成 json 并渲染。使用 setAttr 设置的其它属性并不转换为 json。

-- 其他
renderFile(“test.zip”); 渲染名为 test.zip 的文件，一般用于文件下载
renderText(“Hello Jboot”) 渲染纯文本内容”Hello Jboot”。
renderHtml(“Hello Html”) 渲染 Html 内容”Hello Html”。
renderError (404 , “test.html”) 渲染名为 test.html 的文件，且状态为 404。
renderError (500 , “test.html”) 渲染名为 test.html 的文件，且状态为 500。
renderNull() 不渲染，即不向客户端返回数据。
render(new MyRender()) 使用自定义渲染器 MyRender 来渲染。

# session
-- session 与 分布式session
在Jboot的设计中，分布式的session是依赖分布式缓存的，jboot中，分布式缓存提供了3种方式
所以，在使用jboot的分布式session之前，需要在jboot.properties配置上jboot分布式的缓存。
例如：
jboot.cache.type=redis
jboot.cache.redis.host = 127.0.0.1
jboot.cache.redis.password = 123456
jboot.cache.redis.database = 1
配置好缓存后，直接在Controller里调用getSessionAttr(key) 或 setSessionAttr(key,value) 即可。

# 限流和流量控制--测试未通过
- 在Jboot中，默认提供了4个注解进行流量管控。4个注解代表着四个不同的流量管控方案，他们分别是：
指令                    描述
EnableConcurrencyLimit  限制当前Action的并发量
EnablePerIpLimit        限制每个IP的每秒访问量
EnablePerUserLimit      限制每个用户的访问量
EnableRequestLimit      限制总体每秒钟可以通过的访问量
- 使用示例:

    @RequestMapping("/limitation")
    public class LimitationDemo extends JbootController {
        public static void main(String[] args) {
            Jboot.setBootArg("jboot.limitation.webPath","/limitation/view");
            Jboot.run(args);
        }
        
        @EnableRequestLimit(rate = 1)//所有的请求，每1秒钟只能访问一次
        @EnableConcurrencyLimit(rate = 1)//所有的请求，并发量为1个
        @EnablePerIpLimit(rate = 0.2)//每个IP地址，每5秒钟只能访问一次
        //所有的请求，每1秒钟只能访问一次;被限制的请求，自动跳转到 /limitation/request2
        @EnableRequestLimit(rate = 1, renderType = LimitRenderType.REDIRECT, renderContent = "/limitation/request2")
        @EnablePerUserLimit(rate = 0.2, renderType = LimitRenderType.TEXT, renderContent = "被限制啦")//每个用户，每5秒钟只能访问一次
        public void request() {
            renderText("request() render ok");
        }
        
- 使用Jboot在线流量管理，首先配置上流量管理的URL地址，例如：
    jboot.limitation.webPath = /jboot/limitation

#  websocket
在使用websocket之前，需要在jboot.properties文件上配置启动websocket，例如：
jboot.web.websocketEnable = true
jboot.web.websocketBufferPoolSize = 100   #默認值

# shiro的使用--测试未通过(缺少依赖)
--shiro 配置
在Jboot中使用shiro非常简单，只需要在resources目录下配置上您的shiro.ini文件即可。在shiro.ini文件里，需要在自行扩展realm等信息。
參考: ShiroController  

# jwt
在客户端使用JWT的场景一般是用于非浏览器的第三方进行认证，例如：APP客户端，前后端分离的AJAX请求等。

    例如，在登录后，服务器Server会通过 setJwtAttr() 设置上用户数据，
    客户端可以去获取 HTTP 响应头中的 Jwt，就可以获取 服务器渲染的 Jwt 信息，
    此时，应该把 Jwt 的信息保存下来，比如保存到 cookie 或 保存在storage等，
     
    在客户每次请求服务器 API 的时候，应该把 Jwt 设置在请求的 http 头中的 Jwt（注意，第一个字母大写），
    服务器就可以获取到具体是哪个 “用户” 进行请求了。
关于JWT的方法：
方法调用        描述
setJwtAttr()    设置 jwt 的 key 和 value
setJwtMap()     把整个 map的key和value 设置到 jwt
getJwtAttr()    获取 已经设置进去的 jwt 信息
getJwtAttrs()   获取 所有已经设置进去的 jwt 信息
getJwtPara()    获取客户端传进来的 jwt 信息，若 jwt 超时或者不被信任，那么获取到的内容为null

參考 JWTController

