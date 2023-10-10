package br.com.jhonatas.todolist.controller.user;

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
    public void create(@RequestBody UserModel UserModel){

        System.out.println(UserModel.getUsername());

    }

}
