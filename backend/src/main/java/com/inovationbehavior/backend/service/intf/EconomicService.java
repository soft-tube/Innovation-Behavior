package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.entity.economic.Article;
import com.inovationbehavior.backend.entity.economic.ArticleList;
import org.springframework.stereotype.Service;

@Service
public interface EconomicService {
    ArticleList getArticleByPage(Integer page, Integer size, String type);

    Article getArticleById(Long id);
}
