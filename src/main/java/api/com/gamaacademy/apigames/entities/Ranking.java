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
    private long idRanking;
    @Column(nullable = false)
    private int pontuacao;
    @Column(nullable = true)

    private String dataPontuacao;

    @ManyToOne(targetEntity = Jogador.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore()
    @JoinColumn(name = "idJogador")
    private Jogador jogador;

    @ManyToOne(targetEntity = Jogo.class )
     @JsonIgnore()
    @JoinColumn(name = "idJogo")
    private Jogo jogo;

    @Deprecated
    public Ranking(){}

    public Ranking(long idRanking, int pontuacao, String dataPontuacao, Jogador jogador, Jogo jogo) {
        this.idRanking = idRanking;
        this.pontuacao = pontuacao;
        this.dataPontuacao = dataPontuacao;
        this.jogador = jogador;
        this.jogo = jogo;
    }

    public long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(long idRanking) {
        this.idRanking = idRanking;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getDataPontuacao() {
        return dataPontuacao;
    }

    public void setDataPontuacao(String dataPontuacao) {
        this.dataPontuacao = dataPontuacao;
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
                "idRanking=" + idRanking +
                ", pontuacao=" + pontuacao +
                ", dataPontuacao='" + dataPontuacao + '\'' +
                ", jogador=" + jogador +
                ", jogo=" + jogo +
                '}';
    }
}
