package com.chanho.LoveDay.controller;

import com.chanho.LoveDay.domain.Posts;
import com.chanho.LoveDay.dto.PostsSaveRequestDto;
import com.chanho.LoveDay.service.CalendarService;
import com.chanho.LoveDay.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;
    private final CalendarService calendarService;

    @GetMapping("/api/vl/getPost")
    public List<Posts> findAll(@RequestParam("writer") String writer, @RequestParam("partner") Optional<String> partner) {
        if (partner.isPresent()) {
            return postsService.findPostsByWriters(writer, partner.get());
        } else {
            return postsService.findPostsByWriter(writer);
        }
    }

    @PostMapping("/api/vl/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
