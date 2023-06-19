package com.chanho.LoveDay.repository;

import com.chanho.LoveDay.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByWriterIn(List<String> writers);
    List<Posts> findAllByWriter(String writer);

    void deletePostsByIdAndWriter(Long id, String writer);
}
