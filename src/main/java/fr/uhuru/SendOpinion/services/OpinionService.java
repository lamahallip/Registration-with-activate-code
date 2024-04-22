package fr.uhuru.SendOpinion.services;

import fr.uhuru.SendOpinion.entities.Opinion;
import fr.uhuru.SendOpinion.repositories.OpinionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class OpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    public Opinion create(Opinion opinion) {
        return this.opinionRepository.save(opinion);
    }

}
