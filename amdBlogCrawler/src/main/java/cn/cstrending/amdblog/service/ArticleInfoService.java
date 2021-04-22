package cn.cstrending.amdblog.service;

import cn.cstrending.amdblog.pojo.Article;

import java.util.List;

public interface ArticleInfoService {

    // 保存文章信息
    public void save(Article article);

    // 查询文章信息
    public List<Article> findArticleInfo(Article article);
}
