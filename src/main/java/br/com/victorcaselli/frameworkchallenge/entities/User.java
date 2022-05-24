package br.com.victorcaselli.frameworkchallenge.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FC_USR")
public class User implements Serializable {

    private static final long serialVersionUID = 274440282299828642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id") )
    private final Set<Role> roles = new HashSet<>();
}
