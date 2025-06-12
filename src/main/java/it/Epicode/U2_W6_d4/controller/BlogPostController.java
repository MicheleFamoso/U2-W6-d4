package it.Epicode.U2_W6_d4.controller;



import it.Epicode.U2_W6_d4.dto.BlogPostDto;
import it.Epicode.U2_W6_d4.exception.NonTrovatoException;
import it.Epicode.U2_W6_d4.model.BlogPost;
import it.Epicode.U2_W6_d4.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPostDto blogPostDto) throws NonTrovatoException {

        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping("/blogpost")
    public List<BlogPost> getBlogPosts(){

        return blogPostService.getBlogPosts();
    }

    @GetMapping("/blogpost/{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws NonTrovatoException {
        return blogPostService.getBlogPost(id);
    }
    @PutMapping("/blogpost/{id}")
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPostDto blogPostDto) throws NonTrovatoException {
        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/blogpost/{id}")
    public void deleteBlogPost(@PathVariable int id) throws NonTrovatoException {
        blogPostService.deleteBlogPost(id);
    }
}
