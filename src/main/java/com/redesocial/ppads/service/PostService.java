package com.redesocial.ppads.service;

import com.redesocial.ppads.entity.Post;
import com.redesocial.ppads.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post create(Post post){
        return postRepository.save(post);
    }

    public List<Post> readAll() {
        return postRepository.findAll();
    }

    public Post readById(Integer id){
        if(postRepository.existsById(id)){
            postRepository.findById(id);
        }
        return null;
    }

    public boolean delete(Integer id){
        if (postRepository.existsById(id)){
            postRepository.delete(postRepository.findById(id).get());
            return true;
        }
        return false;
    }

    public List<Post> readByEmail(String email) {
        return postRepository.findByEmailAutor(email);
    }

    public Post atualizaPost(Post post) {
        if (postRepository.existsById(post.getId())){
            Post post_update = postRepository.findById(post.getId()).get();
            post_update.setPublicacao(post.getPublicacao());
            post_update.setCurtidas(post.getCurtidas());
            return postRepository.save(post_update);
        }
        return postRepository.save(post);
    }
}
