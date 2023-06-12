package com.chanho.LoveDay.service;

import com.chanho.LoveDay.domain.Posts;
import com.chanho.LoveDay.dto.PostsSaveRequestDto;
import com.chanho.LoveDay.dto.PostsUpdateRequestDto;
import com.chanho.LoveDay.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public List<Posts> findPostsByWriters(String writer, String partner) {
        return postsRepository.findAllByWriterIn(List.of(writer, partner));
    }

    public List<Posts> findPostsByWriter(String writer) {
        return postsRepository.findAllByWriter(writer);
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return  postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void deletePostsByTitleAndWriter(String title, String writer) {
        postsRepository.deleteByTitleAndWriter(title, writer);
    }

    @Transactional
    public Long update(PostsUpdateRequestDto requestDto) {
        Posts post = postsRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + requestDto.getId()));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return post.getId();
    }

}
