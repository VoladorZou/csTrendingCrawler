package cn.cstrending.amdblog.task;

import cn.cstrending.amdblog.pojo.Article;
import cn.cstrending.amdblog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class SpringDataPipeline implements Pipeline {

    @Autowired
    private ArticleInfoService articleInfoService;

    @Override
    public void process(ResultItems resultItems, Task task){
        // 获取封装好的数据
        Article article = resultItems.get("articleInfo");
        // 判断数据是否为空
        if(article != null){
            this.articleInfoService.save(article);
        }

    }
}
