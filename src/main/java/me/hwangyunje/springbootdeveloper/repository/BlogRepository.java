package me.hwangyunje.springbootdeveloper.repository;

import me.hwangyunje.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
