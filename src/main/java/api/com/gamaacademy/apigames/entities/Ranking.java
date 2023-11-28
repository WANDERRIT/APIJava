package api.com.gamaacademy.apigames.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(nullable = true)

    private String data_pontuacao;

    @ManyToOne(targetEntity = Jogador.class)
    @JsonIgnore()
    @JoinColumn(name = "id_jogador")
    private Jogador jogador;

    @ManyToOne(targetEntity = Jogo.class)
    @JsonIgnore()
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    @Deprecated
    public Ranking(){}

    public Ranking(int pontuacao, String data_pontuacao, Jogador jogador, Jogo jogo,long id_ranking) {
        this.pontuacao = pontuacao;
        this.data_pontuacao = data_pontuacao;
        this.jogador = jogador;
        this.jogo = jogo;
        this.id_ranking = id_ranking;
    }

    public void setId_ranking(long idRanking) {
        this.id_ranking = idRanking;
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

    public String getDataPontuacao() {
        return data_pontuacao;
    }

    public void setDataPontuacao(String dataPontuacao) {
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
