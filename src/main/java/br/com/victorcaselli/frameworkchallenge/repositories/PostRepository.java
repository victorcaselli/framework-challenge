package br.com.victorcaselli.frameworkchallenge.repositories;

import br.com.victorcaselli.frameworkchallenge.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(Long id);

//    @Query("SELECT obj from Post obj where obj.text like CONCAT('%', :text , '%') " +
//            " and (COALESCE(:image, null) IS NULL OR :image in (obj.images) )")
//
//    Post findByParams(String text, String image);
}
