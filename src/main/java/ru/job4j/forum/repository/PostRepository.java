package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.entity.Post;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {

    Optional<Post> findById(Integer id);
    void deleteById(Integer id);
}
