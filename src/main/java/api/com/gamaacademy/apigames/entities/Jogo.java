package api.com.gamaacademy.apigames.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogo")
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome_jogo;

    @Column(nullable = false, length = 50)
    private String nome_autor;


    @Column(nullable = false, length = 50)
    private String website_jogo;

    @OneToMany(mappedBy = "ranking")
    private List<Ranking> rankings;

}
