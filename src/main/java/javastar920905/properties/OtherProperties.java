package javastar920905.properties;

import io.jboot.config.annotation.PropertyConfig;

/**
 * @author ouzhx  on ${date}
 * 读取 other.properties
 * jboot.myconfig.name=aaa
 * jboot.myconfig.passowrd=bbb
 * jboot.myconfig.age=10
 *
 * OtherProperties config = Jboot.config(OtherProperties.class);
 */
@PropertyConfig(prefix="jboot.myconfig",file="other.properties")
public class OtherProperties {
    private String name;
    private String password;
    private int age;

    //getter setter 略

}
