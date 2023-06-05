package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsDeleteRequestDto {
    private String title;
    private String writer;

    @Builder public PostsDeleteRequestDto(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }

    public Posts toEntity() {
        return Posts.builder().title(title).writer(writer).build();
    }
}
