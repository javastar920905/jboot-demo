package javastar920905.properties;

import io.jboot.config.annotation.PropertyConfig;

/**
 * @author ouzhx  on ${date}
 * <p>
 * 读取jboot.properties的配置信息
 * jboot.myconfig.name=aaa
 * jboot.myconfig.passowrd=bbb
 * jboot.myconfig.age=10
 */
@PropertyConfig(prefix = "jboot.myconfig")
public class JbootProperties {
    private String name;
    private String password;
    private int age;

    //getter setter 略

}
