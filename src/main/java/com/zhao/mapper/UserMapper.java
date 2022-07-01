package com.zhao.mapper;


import com.zhao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


//表示这是一个mybatis的Mapper类
@Mapper
@Repository//让Spring创建一个Dao层的类的实现类接口实例，
// 当service需要使用spring创建的Dao层实现类接口时，可以使用@Resource注解告诉Spring，把创建好的dao层注入service
public interface UserMapper {

     User queryByName(String name);
     User queryByUsername(String Username);
     int insertUser(User user);


}
