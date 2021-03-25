package com.sanyoni.doongdoong.entity;

import com.sanyoni.doongdoong.dto.ArticleCreateRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Article extends TimestampedBase {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String contents;

    public Article(ArticleCreateRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.author = requestDTO.getAuthor();
        this.contents = requestDTO.getContents();
    }

    public Long update(ArticleCreateRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.author = requestDTO.getAuthor();
        this.contents = requestDTO.getContents();

        return this.id;
    }
}
