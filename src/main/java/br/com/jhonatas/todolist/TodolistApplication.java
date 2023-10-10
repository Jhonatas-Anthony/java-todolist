package br.com.jhonatas.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}


/* 
 * O spring boot funciona de forma recursiva, o metodo controntroller 
 * só funciona pois a pasta controller está dentro do arquivo todolist
 * 
 * Para permitir que o spring gerencie o projeto da forma correta, todos os arquivos (a maioria) deve estar 
 * aqui dentro para funcionar
 */