package br.com.victorcaselli.frameworkchallenge.repositories;

import br.com.victorcaselli.frameworkchallenge.entities.PhotoCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoCollectionRepository extends JpaRepository<PhotoCollection, Long> {

}
