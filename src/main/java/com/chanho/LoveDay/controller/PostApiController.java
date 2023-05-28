package com.chanho.LoveDay.controller;

import com.chanho.LoveDay.domain.Posts;
import com.chanho.LoveDay.dto.PostsSaveRequestDto;
import com.chanho.LoveDay.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @GetMapping("/api/vl/getPost")
    public List<Posts> findAll() {
        return postsService.findAll();
    }

    @PostMapping("/api/vl/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
