package com.sanyoni.doongdoong.dto;

import com.sanyoni.doongdoong.entity.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ArticleCreateRequestDTO {
    private final String title;

    private final String author;

    private final String contents;

    public ArticleCreateRequestDTO(Article article){
        this.title = article.getTitle();
        this.author = article.getAuthor();
        this.contents = article.getContents();
    }
}
