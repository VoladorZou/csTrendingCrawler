package cn.cstrending.amdblog.service.impl;

import cn.cstrending.amdblog.dao.ArticleInfoDao;
import cn.cstrending.amdblog.pojo.Article;
import cn.cstrending.amdblog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoDao articleInfoDao;

    @Override
    @Transactional
    public void save(Article article) {
        // 判断数据库中是否已有
        Article param = new Article();
        param.setArticletitle(article.getArticletitle());
        // 执行查询
        List<Article> list = this.findArticleInfo(param);
        // 若不存在，则新增
        if(list.size()==0){
            this.articleInfoDao.saveAndFlush(article);
        }

    }

    @Override
    public List<Article> findArticleInfo(Article article) {

        // 设置查询条件
        Example example = Example.of(article);
        // 执行查询
        List list = this.articleInfoDao.findAll(example);

        return list;
    }
}
