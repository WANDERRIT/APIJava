package api.com.gamaacademy.apigames.services;

import api.com.gamaacademy.apigames.entities.Jogador;
import api.com.gamaacademy.apigames.entities.Jogo;
import api.com.gamaacademy.apigames.repositories.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public Jogo createGame(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    public List<Jogo> findAll(){
    List<Jogo> jogos = new ArrayList<>();
    jogoRepository.findAll();
    return jogos;
    }

    public Optional<Jogo> findById(Long id){
        return jogoRepository.findById(id);
    }

    public void delete(Long id){
        jogoRepository.deleteById(id);
    }
}
