package com.chanho.LoveDay.controller;

import com.chanho.LoveDay.domain.Posts;
import com.chanho.LoveDay.dto.PostsDeleteRequestDto;
import com.chanho.LoveDay.dto.PostsSaveRequestDto;
import com.chanho.LoveDay.dto.PostsUpdateRequestDto;
import com.chanho.LoveDay.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;


    @GetMapping("/api/memo")
    public List<Posts> findAll(@RequestParam("writer") String writer, @RequestParam("partner") Optional<String> partner) {
        if (partner.isPresent()) {
            return postsService.findPostsByWriters(writer, partner.get());
        } else {
            return postsService.findPostsByWriter(writer);
        }
    }

    @PostMapping("/api/memo")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @DeleteMapping("/api/memo")
    public ResponseEntity<String> deleteMemo(@RequestBody PostsDeleteRequestDto requestDto) {
        postsService.deletePostsById(requestDto.getId(), requestDto.getWriter());
        return ResponseEntity.ok("Memo deleted successfully");
    }

    @PutMapping("/api/memo")
    public ResponseEntity<Long> updateMemo(@RequestBody PostsUpdateRequestDto requestDto) {
        Long updatedPostId = postsService.update(requestDto);
        return ResponseEntity.ok(updatedPostId);
    }
}
