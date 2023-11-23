package api.com.gamaacademy.apigames.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogador")
@Entity


public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String nome_jogador;

    @Column(nullable = false, length = 50)
    private String nickname_jogador;

    @Column(nullable = false, length = 50)
    private String email_jogador;

    @OneToMany(mappedBy = "ranking")
    private List<Ranking> rankings;


}
