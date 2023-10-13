package br.com.jhonatas.todolist.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;


/*
 * Modificadores:
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // Com esse parâmetro consigo fazer com que o spring gerencie esse repositório para mim
    @Autowired
    private IUserRepository userRepository;

    /* 
     * String
     * Integer
     * Double
     * Float
     * char
     * Date
     * void
     */
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var exists = this.userRepository.findByUsername(userModel.getUsername());

        if(exists != null){
            //Mensagem de erro + status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var password = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(password);

        // var userCreated = this.userRepository.save(userModel);
        this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");

    }

}
