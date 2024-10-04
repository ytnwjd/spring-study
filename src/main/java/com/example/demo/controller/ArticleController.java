package com.example.demo.controller;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form){

        log.info(form.toString());

        Article article = form.toEntity();
        // System.out.println(article.toString());
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
}
