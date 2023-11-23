package api.com.gamaacademy.apigames.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "tb_historico_pontos")
@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int pontuacao;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime publishedOn;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;


}
