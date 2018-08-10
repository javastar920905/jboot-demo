package javastar920905;

import io.jboot.Jboot;
import io.jboot.codegen.model.JbootModelGenerator;
import io.jboot.codegen.service.JbootServiceGenerator;

/**
 * @author ouzhx  on ${date}
 */
public class GeneratorCode {
    //model 的包名
    public static final String modelPackage = "javastar920905.model";
    //生成service 的包名
    public static final String basePackage = "javastar920905.service";

    public static void main(String[] args) {
        //第一步：jboot.properties 配置数据源
        Jboot.setBootArg("jboot.datasource.url", "jdbc:mysql://127.0.0.1:3306/jbootdemo");
        Jboot.setBootArg("jboot.datasource.user", "root");
        genModel();
        genService();

    }

    public static void genModel() {

        JbootModelGenerator.run(modelPackage);
    }

    public static void genService() {
        JbootServiceGenerator.run(basePackage, modelPackage);

    }
}
