package me.hwangyunje.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.hwangyunje.springbootdeveloper.domain.Article;
import me.hwangyunje.springbootdeveloper.dto.AddArticleRequest;
import me.hwangyunje.springbootdeveloper.dto.ArticleResponse;
import me.hwangyunje.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@RestController
public class BolgApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArtice = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArtice);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }
}
