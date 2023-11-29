package api.com.gamaacademy.apigames.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogador")
@Entity


public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogador;

    @Column(nullable = false, length = 50)
    private String nomeJogador;

    @Column(nullable = false, length = 50)
    private String nicknameJogador;

    @Column(nullable = false, length = 50)
    private String emailJogador;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("jogador")
    private List<Ranking> rankings;


    @Deprecated
    public Jogador(){}

    public Jogador(long idJogador, String nomeJogador, String nicknameJogador, String emailJogador, List<Ranking> rankings) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.nicknameJogador = nicknameJogador;
        this.emailJogador = emailJogador;
        this.rankings = rankings;
    }

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNicknameJogador() {
        return nicknameJogador;
    }

    public void setNicknameJogador(String nicknameJogador) {
        this.nicknameJogador = nicknameJogador;
    }

    public String getEmailJogador() {
        return emailJogador;
    }

    public void setEmailJogador(String emailJogador) {
        this.emailJogador = emailJogador;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "idJogador=" + idJogador +
                ", nomeJogador='" + nomeJogador + '\'' +
                ", nicknameJogador='" + nicknameJogador + '\'' +
                ", emailJogador='" + emailJogador + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
