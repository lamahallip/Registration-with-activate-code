package fr.uhuru.SendOpinion.services;

import fr.uhuru.SendOpinion.entities.TypeOfStatus;
import fr.uhuru.SendOpinion.entities.User;
import fr.uhuru.SendOpinion.entities.Validation;
import fr.uhuru.SendOpinion.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {

        // Verify address email synthax
        if(!user.getEmail().contains(".") || !user.getEmail().contains("@")) {
            throw new RuntimeException("Address Email Invalid");
        }

        // Password crypted
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default Status
        user.setStatus(TypeOfStatus.UTILISATEUR);

        User userSave = this.userRepository.save(user);
        this.validationService.saveValidation(userSave);

        return userSave;
    }

    public void activation (Map<String, String> code) {

        Validation validation = this.validationService.recoveryValidation(code.get("code"));

        if(Instant.now().isAfter(validation.getDelay())) {
            throw new RuntimeException("Votre code a expiré ! Veuillez recommencer le processus");
        }

        User user = validation.getUser();
        user.setActivate(true);
        this.userRepository.save(user);

    }
}
