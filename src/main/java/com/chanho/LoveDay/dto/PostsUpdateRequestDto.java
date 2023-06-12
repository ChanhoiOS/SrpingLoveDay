package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private Long id;
    private String title;
    private String content;

    @Builder public PostsUpdateRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder().id(id).title(title).content(content).build();
    }
}
