package com.redesocial.ppads.controller;

import com.redesocial.ppads.entity.Post;
import com.redesocial.ppads.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/redesocial/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/listar")
    public List<Post> listaPost(){
        return postService.readAll();
    }

    @GetMapping("/listarPorId/{id}")
    public Post postPorId(@PathVariable Integer id){
        return postService.readById(id);
    }

    @GetMapping("/listarPorEmail/{email}")
    public List<Post> postsPorEmail(@PathVariable String email) { return postService.readByEmail(email); }

    @PostMapping("/criar")
    public Post criarPost(@RequestBody Post post){
        return postService.create(post);
    }

    @DeleteMapping("/deletar")
    public boolean deletarPost(@PathVariable Integer id){
        return postService.delete(id);
    }
}
