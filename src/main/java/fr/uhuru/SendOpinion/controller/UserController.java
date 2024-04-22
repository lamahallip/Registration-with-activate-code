package fr.uhuru.SendOpinion.controller;

import fr.uhuru.SendOpinion.entities.User;
import fr.uhuru.SendOpinion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping(value = "api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.register(user), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/activation")
    public void activation (@RequestBody Map<String, String> code) {
        this.userService.activation(code);
    }
}
