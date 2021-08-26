package ru.job4j.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String createPostPage(){
        return "post/create";
    }

    @GetMapping("/edit")
    public String editPostPage(@RequestParam("id") Integer id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "post/edit";
    }

    @PostMapping("/save")
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/index";
    }

    @PostMapping("/edit")
    public String editPost( @ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String deletePost( @RequestParam("id") Integer id) {
        postService.deleteTopic(id);
        return "redirect:/index";
    }

}
