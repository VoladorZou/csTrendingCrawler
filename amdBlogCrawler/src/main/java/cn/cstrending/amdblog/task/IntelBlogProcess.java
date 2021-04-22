//package cn.cstrending.amdblog.task;
//
//import cn.cstrending.amdblog.pojo.Article;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
//import us.codecraft.webmagic.scheduler.QueueScheduler;
//import us.codecraft.webmagic.selector.Html;
//import us.codecraft.webmagic.selector.Selectable;
//
//import java.util.List;
//
//@Component
//public class IntelBlogProcess implements PageProcessor {
//
//    @Autowired
//    private SpringDataPipeline springDataPipeline;
//
//    private String url = "https://newsroom.intel.cn/#gs.zb8tgf";
//
////    private StringBuffer articleUrl = new StringBuffer();
//    String articleUrl = null;
//
//    @Override
//    public void process(Page page) {
//
////        // 测试能否获取页面
////        String html = page.getHtml().toString();
////        System.out.println(html);
//
//        List<Selectable> list = page.getHtml().css("div.blade-content div.col-xl-3").nodes();
//
//        if(list.size() == 0){
//            this.saveArticleInfo(page);
//        }else {
//            for(Selectable selectable : list){
//                articleUrl = selectable.links().toString();
//                System.out.println("item: "+articleUrl);
//                page.addTargetRequest(articleUrl);
//            }
////            // 获取下一页
////            String nextPageUrl = page.getHtml().css("li.lia-paging-page-next").links().toString();
////            // 把url加入任务队列
////            page.addTargetRequest(nextPageUrl);
//        }
//    }
//
//    // 解析文章详情页，并保存到mysql
//    private void saveArticleInfo(Page page) {
//        // 创建文章类实体
//        Article article = new Article();
//        // 解析页面
//        Html html = page.getHtml();
//        System.out.println("开始单页下载：");
//        // 赋值给各数据项
//        article.setUserid(1);
//        article.setTag("1");
//        article.setIsdeleted(false);
//        article.setIspermited(false);
//        article.setArticleurl(articleUrl);
//        article.setArticletitle(html.css("h1.entry-title","text").toString());
//        article.setHtmlcode(html.css("div.entry-content").toString());
//        System.out.println(article.toString());
//        // 保存结果
//        page.putField("articleInfo", article);
//    }
//
//    private Site site = Site.me()
//            .setCharset("utf8")
//            .setTimeOut(100*3000)
//            .setRetrySleepTime(3000)
//            .setRetryTimes(3);
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    // initialDelay 任务启动后，等待多久执行方法
//    // fixedDelay 间隔多久，重新执行
//    @Scheduled(initialDelay = 2000, fixedDelay = 100*100)
//    public void process(){
//        Spider.create(new IntelBlogProcess())
//                .addUrl(url)
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100)))
//                .thread(5)
//                .addPipeline(this.springDataPipeline)
//                .run();
//    }
//}
