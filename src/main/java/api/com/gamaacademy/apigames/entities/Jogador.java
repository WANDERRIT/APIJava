package api.com.gamaacademy.apigames.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogador")
@Entity


public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jogador;

    @Column(nullable = false, length = 50)
    private String nome_jogador;

    @Column(nullable = false, length = 50)
    private String nickname_jogador;

    @Column(nullable = false, length = 50)
    private String email_jogador;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("jogador")
    private List<Ranking> rankings;

    @Deprecated
    public Jogador(){}

    public Jogador(String nome_jogador, String nickname_jogador, String email_jogador, List<Ranking> rankings,long id_jogador) {
        this.nome_jogador = nome_jogador;
        this.nickname_jogador = nickname_jogador;
        this.email_jogador = email_jogador;
        this.rankings = rankings;
        this.id_jogador = id_jogador;
    }

    public void setId_jogador(long idJogador) {
        this.id_jogador = idJogador;
    }

    public long getIdJogador() {
        return id_jogador;
    }

    public String getNomeJogador() {
        return nome_jogador;
    }

    public void setNomeJogador(String nomeJogador) {

        this.nome_jogador = nomeJogador;
    }

    public String getNicknameJogador() {

        return nickname_jogador;
    }

    public void setNicknameJogador(String nicknameJogador) {

        this.nickname_jogador = nicknameJogador;
    }

    public String getEmailJogador() {

        return email_jogador;
    }

    public void setEmailJogador(String emailJogador) {
        this.email_jogador = emailJogador;
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
                "id_jogador=" + id_jogador +
                ", nome_jogador='" + nome_jogador + '\'' +
                ", nickname_jogador='" + nickname_jogador + '\'' +
                ", email_jogador='" + email_jogador + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
