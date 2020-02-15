package cn.js.today.repository.cms;

import cn.js.today.domain.cms.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByTitle(String title);
}
