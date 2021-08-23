package ru.job4j.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/index";
    }
}
