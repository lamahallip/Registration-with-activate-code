package fr.uhuru.SendOpinion.repositories;

import fr.uhuru.SendOpinion.entities.Opinion;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {
}
