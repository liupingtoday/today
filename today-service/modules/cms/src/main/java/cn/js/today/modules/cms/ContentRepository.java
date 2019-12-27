package cn.js.today.modules.cms;

import cn.js.today.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-08-09
 * @UpdateUser: liuping
 * @UpdateDate: 2019-08-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {

    Optional<Content> findOneByTitle(String title);

//    Optional<Content> findOne(Long id);

}
