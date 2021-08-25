package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private static AtomicInteger id = new AtomicInteger(0);
    private final List<Post> posts = new ArrayList<>();

    public PostService() {
    }

    public List<Post> getAll() {
        return posts;
    }

    public Integer save(Post post) {
        if(post != null) {
            post.setId(id.getAndIncrement());
            posts.add(post);
        }
        return id.get();
    }

    public void deleteTopic(Integer id) {
        posts.remove(id);
    }

    public Post findById(Integer id) {
        return posts.get(id);
    }

    public void update(Post post) {
        Post postFromBd = findById(post.getId());
        postFromBd.setName(post.getName());
        postFromBd.setDesc(post.getDesc());
    }
}
