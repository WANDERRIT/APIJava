package api.com.gamaacademy.apigames.controllers;


import api.com.gamaacademy.apigames.entities.Jogador;
import api.com.gamaacademy.apigames.repositories.JogadorRepository;
import api.com.gamaacademy.apigames.services.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/games"})
@CrossOrigin("*")
public class JogadorController {
    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }

    @GetMapping(path = {"/jogadores"})
    public ResponseEntity<List<Jogador>> findAllPlayers() {
        List<Jogador> jogadores = jogadorService.findAll();
        return ResponseEntity.ok(jogadores);
    }

    @GetMapping(path = {"/jogadores/{id}"})
    public ResponseEntity<Jogador> findbyId(@PathVariable Long id){
        return jogadorService.findById(id)
                .map(jogador -> ResponseEntity.ok().body(jogador))
                .orElse(ResponseEntity.status(404).build()); /*ResponseEntitty.notFound()*/
    }

    @PostMapping(path = {"/jogadores"})
    public ResponseEntity<Jogador> createPlayer(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.createPlayer(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    @PutMapping({"/jogadores/{id}"})
    public  ResponseEntity<Jogador> upadatePlayer(@PathVariable("id") Long id, @RequestBody Jogador updateJogador){
        return jogadorService.findById(id)
                .map(jogador -> {
                    jogador.setNomeJogador(updateJogador.getNomeJogador());
                    jogador.setNicknameJogador(updateJogador.getNicknameJogador());
                    jogador.setEmailJogador(updateJogador.getEmailJogador());
                    Jogador jogadorUpdated = jogadorService.createPlayer(jogador);
                    return ResponseEntity.ok().body(jogadorUpdated);
                }).orElse(ResponseEntity.status(404).build());/*ResponseEntitty.notFound()*/
    }

   @DeleteMapping(path ={"/jogadores/{id}"})
    public ResponseEntity<?> deletePlayer(@PathVariable Long id){
        return jogadorService.findById(id)
                .map(jogador -> {
                    jogadorService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
