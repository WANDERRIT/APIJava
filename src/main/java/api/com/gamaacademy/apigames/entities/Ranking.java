package api.com.gamaacademy.apigames.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "tb_historico_pontos")
@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_ranking;
    @Column(nullable = false)
    private int pontuacao;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data_pontuacao;

    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    @Deprecated
    public Ranking(){}

    public Ranking(int pontuacao, LocalDateTime data_pontuacao, Jogador jogador, Jogo jogo) {
        this.pontuacao = pontuacao;
        this.data_pontuacao = data_pontuacao;
        this.jogador = jogador;
        this.jogo = jogo;
    }

    public long getIdRanking() {
        return id_ranking;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDateTime getDataPontuacao() {
        return data_pontuacao;
    }

    public void setDataPontuacao(LocalDateTime dataPontuacao) {
        this.data_pontuacao = dataPontuacao;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id_ranking=" + id_ranking +
                ", pontuacao=" + pontuacao +
                ", data_pontuacao=" + data_pontuacao +
                ", jogador=" + jogador +
                ", jogo=" + jogo +
                '}';
    }
}
