package com.my.sample.controller;

import com.my.sample.dao.repository.ArticleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Resource
    private ArticleRepository articleRepository;


    @GetMapping("")
    public long test(Pageable page){
        return page.getOffset();
    }
}
