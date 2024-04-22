package fr.uhuru.SendOpinion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;

@Getter
@Setter
@Table(name = "Utilisateur")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private TypeOfStatus status;
    private Boolean activate = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("Role :"+this.status));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.activate;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.activate;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.activate;
    }

    @Override
    public boolean isEnabled() {
        return this.activate;
    }
}
