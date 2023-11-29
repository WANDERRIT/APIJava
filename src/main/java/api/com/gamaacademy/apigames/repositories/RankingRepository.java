package api.com.gamaacademy.apigames.repositories;

import api.com.gamaacademy.apigames.entities.Ranking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long> {

}
