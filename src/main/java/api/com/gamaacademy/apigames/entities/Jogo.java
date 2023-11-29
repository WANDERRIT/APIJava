package api.com.gamaacademy.apigames.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogo")
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogo;

    @Column(nullable = false, length = 100)
    private String nomeJogo;

    @Column(nullable = false, length = 50)
    private String nomeAutor;


    @Column(nullable = false, length = 50)
    private String websiteJogo;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("jogo")
    private List<Ranking> rankings;


    @Deprecated
    public Jogo(){}

    public Jogo(long idJogo, String nomeJogo, String nomeAutor, String websiteJogo, List<Ranking> rankings) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.nomeAutor = nomeAutor;
        this.websiteJogo = websiteJogo;
        this.rankings = rankings;
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getWebsiteJogo() {
        return websiteJogo;
    }

    public void setWebsiteJogo(String websiteJogo) {
        this.websiteJogo = websiteJogo;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "idJogo=" + idJogo +
                ", nomeJogo='" + nomeJogo + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", websiteJogo='" + websiteJogo + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
