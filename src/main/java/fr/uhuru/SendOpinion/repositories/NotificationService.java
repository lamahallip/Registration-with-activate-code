package fr.uhuru.SendOpinion.repositories;

import fr.uhuru.SendOpinion.entities.Validation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class NotificationService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendNotification(Validation validation) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("contact@uhuru.fr");
        message.setTo(validation.getUser().getEmail());
        message.setSubject("Code de Validation");
        String nameUser = validation.getUser().getUsername();
        String codeUser = validation.getCode();

        String messageDescription = String.format("Bonjour "+nameUser+", Votre code de validation est : "+codeUser+". Veuillez activer votre compte (Vous avez un delai de 15 min)"
        );

        message.setText(messageDescription);

        javaMailSender.send(message);
    }
}
