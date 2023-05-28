package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;

    //repository 를 통해 조회한 entity 를 dto 로 변환 용도
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
