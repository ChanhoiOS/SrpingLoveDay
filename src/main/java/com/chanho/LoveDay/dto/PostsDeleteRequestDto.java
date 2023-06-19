package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsDeleteRequestDto {
    private Long id;
    private String writer;

    @Builder public PostsDeleteRequestDto(Long id, String writer) {
        this.id = id;
        this.writer = writer;
    }

    public Posts toEntity() {
        return Posts.builder().id(id).writer(writer).build();
    }
}
