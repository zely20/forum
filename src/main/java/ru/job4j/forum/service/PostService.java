package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        List<Post> result = new ArrayList<>();
        postRepository.findAll().forEach(result::add);
        return result;
    }

    public Post save(Post post) {
        if(post != null) {
            Post postForSave = Post.of(post.getName(), post.getDescription());
            return postRepository.save(postForSave);
        }
        return null;
    }

    public void deleteTopic(Integer id) {
        postRepository.deleteById(id);
    }

    public Post findById(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        }
        return null;
    }

    public void update(Post post) {
        Post postFromBd = findById(post.getId());
        postFromBd.setName(post.getName());
        postFromBd.setDescription(post.getDescription());
        postRepository.save(postFromBd);
    }
}
