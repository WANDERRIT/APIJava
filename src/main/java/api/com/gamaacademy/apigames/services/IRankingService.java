package api.com.gamaacademy.apigames.services;

import api.com.gamaacademy.apigames.entities.Ranking;
import org.springframework.stereotype.Service;


public interface IRankingService {
    public Ranking inserirRanking (Ranking novo);
    public Ranking getById(Long id);
}
