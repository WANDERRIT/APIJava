package api.com.gamaacademy.apigames.controllers;

import api.com.gamaacademy.apigames.entities.Jogo;
import api.com.gamaacademy.apigames.services.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/games"})
@CrossOrigin("*")
public class JogoController {
    private JogoService jogoService;
    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @GetMapping(path = {"/jogos"})
    public ResponseEntity<List<Jogo>> findAllGames(){
        List<Jogo> jogos = jogoService.findAll();
        if (jogos != null) {
            return ResponseEntity.ok(jogos);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping(path = {"/jogos/{id}"})
    public ResponseEntity<Jogo> findById(@PathVariable Long id){
        return jogoService.findById(id)
                .map(jogo -> ResponseEntity.ok().body(jogo))
                .orElse(ResponseEntity.status(404).build());
    }

    @PostMapping(path = {"/jogos"})
    public ResponseEntity<Jogo> createGame(@RequestBody Jogo jogo){
        Jogo novoJogo = jogoService.createGame(jogo);
        return ResponseEntity.ok(novoJogo);
    }

    @PutMapping({"/jogos/{id}"})
    public ResponseEntity<Jogo> updateGames (@PathVariable("id") Long id, @RequestBody Jogo jogoUpdated){
     return jogoService.findById(id)
             .map(jogo -> {
                 jogo.setNomeJogo(jogoUpdated.getNomeJogo());
                 jogo.setNomeAutor(jogoUpdated.getNomeAutor());
                 jogo.setWebsiteJogo(jogoUpdated.getWebsiteJogo());
                 jogo.setRankings(jogoUpdated.getRankings());
                 Jogo updatedGame = jogoService.createGame(jogo);
                 return ResponseEntity.status(201).body(updatedGame);
             }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/jogos/{id}"})
    public ResponseEntity<?> deleteGames(@PathVariable Long id){
        return jogoService.findById(id)
                .map(jogo -> {
                    jogoService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
