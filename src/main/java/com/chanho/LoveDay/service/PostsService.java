package com.chanho.LoveDay.service;

import com.chanho.LoveDay.dto.PostsSaveRequestDto;
import com.chanho.LoveDay.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return  postsRepository.save(requestDto.toEntity()).getId();
    }
}
