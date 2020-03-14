package cn.js.today.service.mapper;

import cn.js.today.domain.sys.Config;
import cn.js.today.domain.sys.User;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.dto.sys.UserDTO;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class UserMapper {

    /**
     *
     * @param userDTO
     * @return
     */
    public User userDTO2User(UserDTO userDTO){

        if(userDTO == null){
            return  null;
        } else {
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setLoginCode(userDTO.getLoginCode());
            user.setUserName(userDTO.getUserName());
            user.setAge(userDTO.getAge());
            user.setEmail(userDTO.getEmail());
            user.setMobile(userDTO.getMobile());
            user.setPhone(userDTO.getPhone());
            user.setPassword(userDTO.getPassword());
            user.setBirthday(userDTO.getBirthday());

            return user;
        }

    }
}
