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

    @Builder
    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
