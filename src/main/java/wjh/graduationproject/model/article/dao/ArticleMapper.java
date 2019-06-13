package wjh.graduationproject.model.article.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.entity.ArticleType;

import java.util.List;

/**
 * Created by Administrator on 2019/4/13.
 */
@Mapper
public interface ArticleMapper {
    ArticleEntity getArticle(@Param("articleId") String articleId);
    List<ArticleEntity> getArticles();
    int insertArticles(ArticleEntity articleEntity);
    int updateArticle();
    int deleteArticle(@Param("articleId")String articleId);
    List<ArticleEntity> getArticlesByTime();
    List<ArticleEntity> getArticelsOrderbyReadNum();
    int updateArticleReadNum(@Param("articleId")String articleId);
    List<ArticleType> getTypes();
    int addTypes(@Param("typeId")String typeId);
    List<ArticleEntity> getNotices();
    List<ArticleEntity> getNoticeSide();
    List<ArticleEntity> getArticleSide();
    List<ArticleEntity> getAllArticles(@Param("articleType")String articleType,@Param("userId")String userId,@Param("keyboard") String keyboard);
    List<ArticleEntity> getArticlesByType(@Param("type")String type);
    int subType(@Param("typeId")String typeId);
}
