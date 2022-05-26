package br.com.victorcaselli.frameworkchallenge.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FC_POST")
public class Post implements Serializable {

    private static final long serialVersionUID = 8353977823390868495L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ElementCollection
    private List<String> images = new ArrayList<>(); //
    @ElementCollection
    private List<String> links = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
}
