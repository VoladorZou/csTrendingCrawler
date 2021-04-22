package cn.cstrending.amdblog.dao;

import cn.cstrending.amdblog.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleInfoDao extends JpaRepository<Article, Integer> {

}
