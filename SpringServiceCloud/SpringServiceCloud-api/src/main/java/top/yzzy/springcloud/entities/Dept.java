package top.yzzy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author User
 * 实现序列化接口
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 链式风格访问
 * 这里使用自动驼峰命名的方式
 */
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long 	deptNo;
//    注意这里的dName很容易引起请求传参时无法找到对应的get、set方法，导致参数无法接受
    /**
     * 尽量不要使用首字母大写或者第二个字母大写的属性名
     */
    private String 	dName;
    /**
     * 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String dbSource;
}
