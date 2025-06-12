package it.Epicode.U2_W6_d4.repository;


import it.Epicode.U2_W6_d4.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}
