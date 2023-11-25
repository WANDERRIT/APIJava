package api.com.gamaacademy.apigames.repositories;

import api.com.gamaacademy.apigames.entities.Jogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Long> {
}
