package br.com.jhonatas.todolist.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public UserModel create(@RequestBody UserModel userModel){

        var userCreated = this.userRepository.save(userModel);
        return userCreated;

    }

}
