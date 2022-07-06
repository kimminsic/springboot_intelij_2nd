package com.mysite.sbb.Controller;

import com.mysite.sbb.domain.Article;
import com.mysite.sbb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usr/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    //article 다건조회
    @RequestMapping("/list")
    @ResponseBody
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    //article 단건조회
    @RequestMapping("/detail/")
    @ResponseBody
    public Article getArticle(@RequestParam long id) {
        Optional<Article> article = articleRepository.findById(id);

        return article.orElse(null);
    }

    //article 수정
    @RequestMapping("/doModify/")
    @ResponseBody
    public Article doModifyArticle(long id, String title, String body) {
        Article article = articleRepository.findById(id).get();
        if(title!=null){
            article.setTitle(title);
        }
        if(body!=null){
            article.setBody(body);
        }

        articleRepository.save(article);
        return article;
    }

    //article 삭제
    @RequestMapping("/doDelete/")
    @ResponseBody
    public String doAddArticle(long id) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isEmpty()) {
        return "데이터가 없습니다.";
        }
        else {
            articleRepository.deleteById(id);
            return id + "번째 데이터를 삭제했습니다.";
        }
    }



}
