package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.entity.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of("Продаю машину", "Продаю машину ладу КАЛИНА"));
    }

    public List<Post> getAll() {
        return posts;
    }

    public Integer save(Post post) {
        if(post != null) {
            post.setId(posts.size());
            posts.add(post);
        }
        return this.posts.size()-1;
    }
}
