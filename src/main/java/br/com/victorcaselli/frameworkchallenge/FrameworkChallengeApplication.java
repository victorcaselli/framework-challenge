package br.com.victorcaselli.frameworkchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO - user postman in the root project
//TODO - user's post feature - "Suportar a adição e exclusão de comentários em posts."
//TODO - security features about user's post - "Os posts poderão ser visíveis a todos os usuários. Apenas o criador do comentário poderá ter permissão para excluí-lo."
//TODO - user's photos collection and security feature - "Permitir a criação de álbuns de fotos. As fotos dos álbuns poderão ser visíveis a todos os usuários. Apenas o dono de um álbum poderá excluí-lo."
//TODO - Check validations in the DTO classes
//TODO - user's post postman in the root project
//TODO - photos collection postman in the root project
//TODO - Postgres configuration
//TODO - create the README
//TODO - Complete controllers
//TODO - Create custom exceptions
//TODO - Create exception handler



//Optional features
//TODO - Change ModalMapper to Mapstruct and create new logic for DTO's methods
//TODO - Add swagger in the project
//TODO - Create Patch service method
//TODO - Create all tests
//TODO - Dockerfile
//TODO - Change deprecated security strategy


@SpringBootApplication
public class FrameworkChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkChallengeApplication.class, args);
	}

}
