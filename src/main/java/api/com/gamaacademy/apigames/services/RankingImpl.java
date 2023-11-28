package api.com.gamaacademy.apigames.services;

import api.com.gamaacademy.apigames.entities.Ranking;
import api.com.gamaacademy.apigames.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingImpl implements IRankingService{

    @Autowired
    private RankingRepository rankingRepository;
    @Override
    public Ranking inserirRanking(Ranking novo) {
        return null;
    }

    @Override
    public Ranking getById(Long id) {
        return rankingRepository.findById(id).orElse(null);
    }
}
