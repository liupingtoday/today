package cn.js.today.repository.gantt;

import cn.js.today.domain.gantt.Role;
import cn.js.today.domain.gantt.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-20
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {


    Optional<Role> findOneByRoleId(Long roleId);

    Optional<Role> findOneByName(String name);



}
