package top.kairecession.demo01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import top.kairecession.demo01.User;

import java.util.List;

// 创建dao包就是为了配合@MapperScan直接使用
// 此处Mapper注解就可以省略了
@Mapper
public interface UserMapper {
    @Select("select * from demo01")
    @Results({@Result(property = "classes", column = "class")})
    List<User> getUser();

}
