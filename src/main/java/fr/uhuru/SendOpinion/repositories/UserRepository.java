package fr.uhuru.SendOpinion.repositories;

import fr.uhuru.SendOpinion.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
