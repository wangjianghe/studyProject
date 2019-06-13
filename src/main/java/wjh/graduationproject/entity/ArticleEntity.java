package wjh.graduationproject.entity;

import java.util.Date;

/**
 * Created by Administrator on 2019/4/13.
 */
public class ArticleEntity {
    private String articleId;
    private String articleTitle;
    private String articleShortContext;
    private int articleReadNum;
    private String articleImg;
    private String articleFile;
    private String userId;
    private String userName;
    private Date articleTime;
    private String articleType;
    private String articleTypeName;
    private String articleContext;

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleContext() {
        return articleContext;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleShortContext() {
        return articleShortContext;
    }

    public void setArticleShortContext(String articleShortContext) {
        this.articleShortContext = articleShortContext;
    }

    public int getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(int articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    public String getArticleFile() {
        return articleFile;
    }

    public void setArticleFile(String articleFile) {
        this.articleFile = articleFile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public ArticleEntity() {
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleShortContext='" + articleShortContext + '\'' +
                ", articleReadNum=" + articleReadNum +
                ", articleImg='" + articleImg + '\'' +
                ", articleFile='" + articleFile + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", articleTime='" + articleTime + '\'' +
                ", articleType='" + articleType + '\'' +
                '}';
    }
}
