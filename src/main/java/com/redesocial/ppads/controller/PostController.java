package com.redesocial.ppads.controller;

import com.redesocial.ppads.entity.Post;
import com.redesocial.ppads.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redesocial/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/listar")
    private List<Post> listaPost(){
        return postService.readAll();
    }

    @GetMapping("/listarPorId/{id}")
    private Post postPorId(@PathVariable Integer id){
        return postService.readById(id);
    }

    @PostMapping("/criar")
    private Post criarPost(@RequestBody Post post){
        return postService.create(post);
    }

    @DeleteMapping("/deletar")
    private boolean deletarPost(@PathVariable Integer id){
        return postService.delete(id);
    }
}
