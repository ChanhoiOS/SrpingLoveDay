package com.chanho.LoveDay.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String specialDate;

    @Column(nullable = false)
    private String content;

    @Column()
    private String writer;

    @Builder
    public Calendar(String specialDate, String content, String writer) {
        this.specialDate = specialDate;
        this.content = content;
        this.writer = writer;
    }
}
