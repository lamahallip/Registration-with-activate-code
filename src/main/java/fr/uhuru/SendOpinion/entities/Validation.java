package fr.uhuru.SendOpinion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant created;
    private Instant delay;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String code;

}
