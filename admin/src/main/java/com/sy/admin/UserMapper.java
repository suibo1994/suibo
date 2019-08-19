package com.sy.admin;


import com.sy.sycommon.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/7/29 下午6:02
 */

@Mapper
@Component("userMapper")
public interface UserMapper {

    int deleteById(Integer id);

    int insert(User record);

    User findById(Integer id);

    int update(User record);

    List<User> findAll();

}
