package api.com.gamaacademy.apigames.services;

import api.com.gamaacademy.apigames.entities.Ranking;
import api.com.gamaacademy.apigames.repositories.RankingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public Ranking createRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    public Optional<Ranking> findById(Long id) {
        return rankingRepository.findById(id);
    }

    public List<Ranking> findAll() {
        List<Ranking> rankings = new ArrayList<>();
        rankingRepository.findAll().forEach(rankings::add);
        return rankings;
    }

    public void delete(Long id) {
        rankingRepository.deleteById(id);
    }


}
