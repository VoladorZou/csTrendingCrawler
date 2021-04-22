package cn.cstrending.amdblog.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 文章编号
     */
    private Integer articleid;

    /**
     * 用户编号
     */
    private Integer userid;

    /**
     * 文章的md格式
     */
    private String articlemd;

    /**
     * 文章的html格式
     */
    private String articlehtml;

    /**
     * 文章的写入日期
     */
    private Date createtime;

    /**
     * 数值0代表未审核或未通过，数值1代表审核通过
     */
    private Boolean ispermited;

    /**
     * 文章标题
     */
    private String articletitle;

    /**
     * 文章封面图片
     */
    private String articlecover;

    /**
     * 评论
     */
    private String comment;

    /**
     * 标签或分类
     */
    private String tag;

    /**
     * 测试mysql方式存储md
     */
    private String markdown;

    /**
     * 点赞数
     */
    private Integer thumbsup;

    /**
     * 删除状态
     */
    private Boolean isdeleted;

    /**
     * 浏览量
     */
    private Integer views;

    /**
     * html文本
     */
    private String htmlcode;

    /**
     * 文章来源
     */
    private String articleurl;

    private static final long serialVersionUID = 1L;
}
