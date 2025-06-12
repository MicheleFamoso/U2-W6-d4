package it.Epicode.U2_W6_d4.controller;



import it.Epicode.U2_W6_d4.dto.BlogPostDto;
import it.Epicode.U2_W6_d4.exception.NonTrovatoException;
import it.Epicode.U2_W6_d4.model.BlogPost;
import it.Epicode.U2_W6_d4.service.BlogPostService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) throws NonTrovatoException {

        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
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
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) throws NonTrovatoException {
        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }

        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/blogpost/{id}")
    public void deleteBlogPost(@PathVariable int id) throws NonTrovatoException {
        blogPostService.deleteBlogPost(id);
    }
}
