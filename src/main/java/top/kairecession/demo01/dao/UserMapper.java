package top.kairecession.demo01.dao;

import org.apache.ibatis.annotations.*;
import top.kairecession.demo01.User;

import java.util.List;

// 创建dao包就是为了配合@MapperScan直接使用
// 此处Mapper注解就可以省略了
@Mapper
public interface UserMapper {
    @Select("select * from demo01")
    @Results({@Result(property = "classes", column = "class")})
    List<User> getUser();

    @Insert("insert into demo01 (id, name, class, grade) values (#{id}, #{name}, #{classes}, #{grade})")
    Integer insertUser(User user);

}
