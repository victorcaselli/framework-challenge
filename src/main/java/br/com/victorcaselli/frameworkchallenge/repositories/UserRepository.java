package br.com.victorcaselli.frameworkchallenge.repositories;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
