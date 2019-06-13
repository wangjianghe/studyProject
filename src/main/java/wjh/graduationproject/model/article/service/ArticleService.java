package wjh.graduationproject.model.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.model.article.dao.ArticleMapper;

import java.util.List;

/**
 * Created by Administrator on 2019/4/14.
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public List<ArticleEntity> getArticlesOrderbyTime(){
        return articleMapper.getArticlesByTime();
    }
    public List<ArticleEntity> getArticelsOrderbyReadNum(){
        return articleMapper.getArticelsOrderbyReadNum();
    }
}
