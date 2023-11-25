package api.com.gamaacademy.apigames.services;

import api.com.gamaacademy.apigames.entities.Jogador;
import api.com.gamaacademy.apigames.repositories.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository){
    this.jogadorRepository = jogadorRepository;
    }

    public Jogador createPlayer(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> findAll(){
        List<Jogador> jogadores = new ArrayList<>();
        jogadorRepository.findAll().forEach(jogadores::add);
        return jogadores;
    }

    public Optional<Jogador> findById(Long id){
        return jogadorRepository.findById(id);
    }

    public Jogador update(Jogador jogadorToUpdate){
    return jogadorRepository.save(jogadorToUpdate);
    }

    public void delete(Long id){
        jogadorRepository.deleteById(id);
    }

}
