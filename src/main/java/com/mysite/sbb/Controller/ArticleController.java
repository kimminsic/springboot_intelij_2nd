package com.mysite.sbb.Controller;

import com.mysite.sbb.domain.Article;
import com.mysite.sbb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/usr/article/list")
    @ResponseBody
    public List<Article> getArticles(){
        return articleRepository.findAll();
    }
}
