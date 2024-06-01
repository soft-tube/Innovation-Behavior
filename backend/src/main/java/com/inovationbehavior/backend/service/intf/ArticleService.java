package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.entity.economic.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    Article createArticle(Article article);
    void deleteArticle(Long id);

    void updateArticle(Article article);
}
