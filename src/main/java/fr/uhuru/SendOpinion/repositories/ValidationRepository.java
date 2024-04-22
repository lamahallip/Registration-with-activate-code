package fr.uhuru.SendOpinion.repositories;

import fr.uhuru.SendOpinion.entities.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation, Long> {

    Optional<Validation> findValidationByCode(String code);
}
