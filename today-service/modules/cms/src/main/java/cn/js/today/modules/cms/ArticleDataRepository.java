package cn.js.today.modules.cms;

import cn.js.today.domain.ArticleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDataRepository extends JpaRepository<ArticleData, Long> {

}
