package br.com.victorcaselli.frameworkchallenge.repositories;


import br.com.victorcaselli.frameworkchallenge.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PictureRepository extends JpaRepository<Picture, Long> {

}
