package com.sanyoni.doongdoong.service;

import com.sanyoni.doongdoong.dto.ArticleCreateRequestDTO;
import com.sanyoni.doongdoong.entity.Article;
import com.sanyoni.doongdoong.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository repository;

    public Long update(Long id, ArticleCreateRequestDTO requestDTO) {
        Article article = repository.findById(id).orElseThrow(() -> new NullPointerException("일치하는 ID의 게시물이 없습니다."));
        return article.update(requestDTO);
    }
}
