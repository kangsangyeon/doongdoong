package com.sanyoni.doongdoong.controller;

import com.sanyoni.doongdoong.dto.ArticleCreateRequestDTO;
import com.sanyoni.doongdoong.entity.Article;
import com.sanyoni.doongdoong.repository.ArticleRepository;
import com.sanyoni.doongdoong.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleRepository repository;
    private final ArticleService service;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<Article> articleList = repository.findAllByOrderByModifiedAtDesc();
        model.addAttribute("articleList", articleList);

        return "index";
    }

    @GetMapping("/articles/create")
    public String getArticleCreatePage() {
        return "articles/create";
    }

    @GetMapping("/articles/{id}")
    public String getArticleDetailsPage(@PathVariable Long id, Model model) {
        try{
            Article article = repository.findById(id).orElseThrow(() -> new NullPointerException("일치하는 ID의 게시물이 없습니다."));
            model.addAttribute("article", article);

            return "articles/details";
        }
        catch(Exception e){
            return "articles/404";
        }

    }

    @ResponseBody
    @PostMapping(value = "/api/articles", produces = "application/json")
    public String createArticle(@RequestBody ArticleCreateRequestDTO requestDTO) {
        JSONObject json = new JSONObject();

        try {
            Article article = new Article(requestDTO);
            repository.save(article);

            json.put("success", true);
            json.put("id", article.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            json.append("success", false);
        }

        return json.toString();
    }

    @ResponseBody
    @GetMapping("/api/articles")
    public List<Article> getArticleList() {
        return repository.findAllByOrderByModifiedAtDesc();
    }

    @ResponseBody
    @GetMapping("/api/articles/{id}")
    public Article getArticleDetails(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new NullPointerException("일치하는 ID의 게시물이 없습니다."));
    }

    @ResponseBody
    @DeleteMapping(value = "/api/articles/{id}", produces = "application/json")
    public String deleteArticle(@PathVariable Long id) {
        JSONObject json = new JSONObject();

        try {
            repository.deleteById(id);

            json.put("success", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            json.put("success", false);
        }

        return json.toString();
    }
}
