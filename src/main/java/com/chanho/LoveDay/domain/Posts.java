package com.chanho.LoveDay.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column()
    private String writer;

    @Column()
    private String createAt;

    @Builder
    public Posts(Long id, String title, String content, String writer, String createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createAt = createAt;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
