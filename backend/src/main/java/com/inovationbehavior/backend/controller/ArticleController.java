package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.entity.Result;
import com.inovationbehavior.backend.entity.economic.Article;
import com.inovationbehavior.backend.service.intf.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("")
    public Result createCourese(@RequestPart("article") Article article){
        return Result.success(articleService.createArticle(article));
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return Result.success();
    }

    @PutMapping("")
    public Result updateArticle(@RequestPart("article") Article article){
        articleService.updateArticle(article);
        return Result.success();
    }
}
