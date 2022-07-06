package com.mysite.sbb.Controller;

import com.mysite.sbb.domain.Article;
import com.mysite.sbb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usr/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    //article 다건조회
    @RequestMapping("")
    @ResponseBody
    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    //article 단건조회
    @RequestMapping("/detail/")
    @ResponseBody
    public Optional<Article> getArticle(long id){
        return articleRepository.findById(id);
    }

    //article 삭제
    @RequestMapping("/doDelete/")
    @ResponseBody
    public void doAddArticle(long id) {articleRepository.deleteById(id);}
}
