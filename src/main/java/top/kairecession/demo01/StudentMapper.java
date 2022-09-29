package top.kairecession.demo01;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface StudentMapper {
    @Select({"select s.*, t.* from \n  actor s left join sub_actor t on \n\ts.actor_id = t.id;"})
    List<actor> get();

    @Select({"select * from sub_actor where id = ${hao}"})
    List<Hobby> gets(@Param("hao") int id);
}
