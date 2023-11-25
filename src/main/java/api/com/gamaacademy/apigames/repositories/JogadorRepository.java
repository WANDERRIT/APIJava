package api.com.gamaacademy.apigames.repositories;

import api.com.gamaacademy.apigames.entities.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}
