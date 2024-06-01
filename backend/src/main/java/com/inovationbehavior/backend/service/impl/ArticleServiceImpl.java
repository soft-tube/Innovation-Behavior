package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.ArticleMapper;
import com.inovationbehavior.backend.entity.economic.Article;
import com.inovationbehavior.backend.service.intf.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article createArticle(Article article) {
        articleMapper.insertArticle(article);

        if (article.getAuthors() != null && !article.getAuthors().isEmpty()) {
            articleMapper.insertAuthor(article.getAuthors(), article.get_id());
        }
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteArticle(id);
    }
    @Override
    public void updateArticle(Article article){
        articleMapper.updateArticle(article);
    }
}
