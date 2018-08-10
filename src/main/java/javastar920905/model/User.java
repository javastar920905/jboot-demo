package javastar920905.model;

import io.jboot.db.annotation.Table;
import io.jboot.db.model.JbootModel;

/**
 * @author ouzhx  on ${date}
 * User 通过继承 Model，便立即拥有的众多方便的操作数据库的方法。
 * <p>
 * 在 User中声明的 dao 静态对象是为了方便查询操作而定义的，该对象并不是必须的。
 * <p>
 * model无需定义 getter、setter 方法，无需 XML 配置，极大降低了代码量。
 * <p>
 * <p>
 * <p>
 * 以下是model常见的用法：
 * // 创建name属性为James,age属性为25的User对象并添加到数据库
 * new User().set("name", "James").set("age", 25).save();
 * // 删除id值为25的User
 * User.dao.deleteById(25);
 * // 查询id值为25的User将其name属性改为James并更新到数据库
 * User.dao.findById(25).set("name", "James").update();
 * // 查询id值为25的user, 且仅仅取name与age两个字段的值
 * User user = User.dao.findByIdLoadColumns(25, "name, age");
 * // 获取user的name属性
 * String userName = user.getStr("name");
 * // 获取user的age属性
 * Integer userAge = user.getInt("age");
 * // 查询所有年龄大于18岁的user
 * List<User> users = User.dao.find("select * from user where age>18");
 * // 分页查询年龄大于18的user,当前页号为1,每页10个user
 * Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user
 * where age > ?", 18);
 */
//@Table注解是给Model使用的，表示让Model映射到哪个数据库表
@Table(tableName = "user", primaryKey = "id")
public class User extends JbootModel<User> {
    public static final User dao = new User().dao();
}
