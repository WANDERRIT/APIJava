package api.com.gamaacademy.apigames.controllers;


import api.com.gamaacademy.apigames.entities.Jogo;
import api.com.gamaacademy.apigames.entities.Ranking;
import api.com.gamaacademy.apigames.services.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/games"})
@CrossOrigin("*")
public class RankingControllers {
    private RankingService rankingService;
    public RankingControllers(RankingService rankingService){
        this.rankingService = rankingService;
    }

    @GetMapping(path = {"/rankings"})
    public ResponseEntity<List<Ranking>> findAllRanking(){
        List<Ranking> rankings = rankingService.findAll();
        if (rankings != null) {
            return ResponseEntity.ok(rankings);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping(path = {"/ranking/{id}"})
    public ResponseEntity<Ranking> getRankingById(@PathVariable Long id){
        return rankingService.findById(id)
                .map(ranking -> ResponseEntity.ok().body(ranking))
                .orElse(ResponseEntity.status(404).build());
    }



    @PostMapping(path = {"/rankings"})
    public ResponseEntity<Ranking> createRanking(@RequestBody Ranking ranking){
        Ranking novoRanking = rankingService.createRanking(ranking);
        return ResponseEntity.ok(novoRanking);
    }

    @DeleteMapping(path = {"/ranking/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        return rankingService.findById(id)
                .map(ranking -> {
                    rankingService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
