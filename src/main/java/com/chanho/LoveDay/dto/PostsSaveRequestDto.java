package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;

    private String writer;
    private String createAt;

    @Builder public PostsSaveRequestDto(String title, String content, String writer, String createAt) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createAt = createAt;
    }

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).writer(writer).createAt(createAt).build();
    }
}
