package br.com.jhonatas.todolist.controller.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "users")
public class UserModel {

    //Metodos públicos: basta chamar fora dessa classe
    /* public String name;
    public String username;
    public String password; */

    // Quando definimos como privados, nos podemos recuperar ou atualizar essas informações com os:
    //Getters and Setters
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String username;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    //Username
    /* public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    } */

    //Name
    /* public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } */

    //Password
    /* public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    } */

    // Invés de digitar tudo manualmente podemos usar o lombok, uma depêndencia que facilita no uso dos Getters e Setters
    //Para usar o lombok podemos dar um @Data para Getters e Setters, um @Getter para apenas Getters e @Setter para apenas Setters
}
