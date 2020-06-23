package cn.js.today.repository.sys;

import cn.js.today.domain.sys.RoleMenu;
import cn.js.today.domain.sys.RoleMenuUPK;
import cn.js.today.domain.sys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-23
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-23
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Repository
public interface RoleMenuRepository extends JpaRepository<RoleMenu, RoleMenuUPK> {

//    Optional<User> findOneByUserId(Long userId);
//
//    Optional<User> findOneByLoginCode(String loginCode);
//
//    Optional<User> findOneByUserName(String userName);


}
