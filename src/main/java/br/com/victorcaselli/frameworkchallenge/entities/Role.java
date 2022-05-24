package br.com.victorcaselli.frameworkchallenge.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "FC_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 2280984206797792348L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
}
