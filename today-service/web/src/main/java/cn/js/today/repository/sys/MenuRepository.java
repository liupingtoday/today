package cn.js.today.repository.sys;

import cn.js.today.domain.sys.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-04
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-04
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

    Optional<Menu> findOneByMenuName(String menuName);

    Optional<Menu> findByMenuCode(String menuName);


}
