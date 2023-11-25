package api.com.gamaacademy.apigames.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_jogo")
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jogo;

    @Column(nullable = false, length = 100)
    private String nome_jogo;

    @Column(nullable = false, length = 50)
    private String nome_autor;


    @Column(nullable = false, length = 50)
    private String website_jogo;

    @OneToMany(mappedBy = "jogo")
    private List<Ranking> rankings;

    @Deprecated
    public Jogo(){}

    public Jogo(String nome_jogo, String nome_autor, String website_jogo, List<Ranking> rankings) {
        this.nome_jogo = nome_jogo;
        this.nome_autor = nome_autor;
        this.website_jogo = website_jogo;
        this.rankings = rankings;
    }

    public long getIdJogo() {
        return id_jogo;
    }

    public String getNomeJogo() {
        return nome_jogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nome_jogo = nomeJogo;
    }

    public String getNomeAutor() {
        return nome_autor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nome_autor = nomeAutor;
    }

    public String getWebsiteJogo() {
        return website_jogo;
    }

    public void setWebsiteJogo(String websiteJogo) {
        this.website_jogo = websiteJogo;
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
                "id_jogo=" + id_jogo +
                ", nome_jogo='" + nome_jogo + '\'' +
                ", nome_autor='" + nome_autor + '\'' +
                ", website_jogo='" + website_jogo + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
