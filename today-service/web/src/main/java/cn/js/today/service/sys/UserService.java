package cn.js.today.service.sys;

import cn.js.today.domain.sys.Config;
import cn.js.today.domain.sys.User;
import cn.js.today.repository.sys.ConfigRepository;
import cn.js.today.repository.sys.UserRepository;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.dto.sys.UserDTO;
import cn.js.today.service.mapper.ConfigMapper;
import cn.js.today.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

//    private final ConfigRepository configRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ConfigMapper configMapper;
    @Autowired
    private UserMapper userMapper;

    public User saveUser(UserDTO userDTO){
        User user = userMapper.userDTO2User(userDTO);
        return userRepository.save(user);
    }

    public User findByUserId(Long userId){
        Optional<User> user = userRepository.findOneByUserCode(userId);
        return user.orElse(null);
    }

    public User findOneByLoginCode(String loginCode){
        Optional<User> user = userRepository.findOneByLoginCode(loginCode);
        return user.orElse(null);
    }

    /**
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findOneByUserName(userName).orElse(null);
    }

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }

}
