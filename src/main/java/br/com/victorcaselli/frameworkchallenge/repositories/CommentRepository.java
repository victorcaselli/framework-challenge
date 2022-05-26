package br.com.victorcaselli.frameworkchallenge.repositories;

import br.com.victorcaselli.frameworkchallenge.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
