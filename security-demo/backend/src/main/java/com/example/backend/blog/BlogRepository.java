package com.example.backend.blog;

import com.example.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
//    Optional<Blog> findById(Long id);

    List<Blog> findByCategory(String category);
}
