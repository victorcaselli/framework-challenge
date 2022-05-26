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
@Table(name = "FC_PH_COLLECT")
public class PhotoCollection implements Serializable {
    private static final long serialVersionUID = 2517265274627470144L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "collection")
    private List<Picture> pictures = new ArrayList<>();
    @ManyToOne
    private User user;
}
