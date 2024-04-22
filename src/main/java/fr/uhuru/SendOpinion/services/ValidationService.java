package fr.uhuru.SendOpinion.services;

import fr.uhuru.SendOpinion.entities.User;
import fr.uhuru.SendOpinion.entities.Validation;
import fr.uhuru.SendOpinion.repositories.NotificationService;
import fr.uhuru.SendOpinion.repositories.ValidationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Service
public class ValidationService {

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private NotificationService notificationService;

    public void saveValidation(User user) {
        Validation validation = new Validation();
        validation.setUser(user);
        Instant dateOfCreated = Instant.now();
        validation.setCreated(dateOfCreated);
        Instant timeOfDelay = dateOfCreated.plus(15, ChronoUnit.MINUTES);
        validation.setDelay(timeOfDelay);
        Random random = new Random();
        String codeGenerated = String.format("%06d", random.nextInt(999999));
        validation.setCode(codeGenerated);

        this.validationRepository.save(validation);
        this.notificationService.sendNotification(validation);

    }

    public Validation recoveryValidation(String code){
        return this.validationRepository.findValidationByCode(code).orElseThrow(() -> new RuntimeException("Validation not found"));
    }
}
