package com.chanho.LoveDay.repository;

import com.chanho.LoveDay.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
