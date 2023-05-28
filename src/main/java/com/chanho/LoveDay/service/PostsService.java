package com.chanho.LoveDay.service;

import com.chanho.LoveDay.domain.Posts;
import com.chanho.LoveDay.dto.PostsSaveRequestDto;
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

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return  postsRepository.save(requestDto.toEntity()).getId();
    }
}
