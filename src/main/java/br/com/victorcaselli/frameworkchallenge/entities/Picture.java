package br.com.victorcaselli.frameworkchallenge.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FC_PIC")
public class Picture implements Serializable {

    private static final long serialVersionUID = -5653986319079318133L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String base64;
    private String description;
    @ManyToOne
    private PhotoCollection collection;
}
