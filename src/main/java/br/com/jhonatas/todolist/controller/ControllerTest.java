package br.com.jhonatas.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

//Para retornar uma estrutura com páginas, templates, permite uma flexibilidade de retornar além de um objeto ou string: 
//  @Controller
//Para construir uma API com rest e restfull
@RestController
// É responsável por estruturar a rota
@RequestMapping("/router")
public class ControllerTest {

    /**
     * GET - Buscar informação
     * POST - Adicionar um dado/informação ou adicionar
     * PUT - Alterar
     * DELETE - Deletar
     * PATCH - Alterar somente uma parte do dado
     * 
     * @return string
     */

    // Funcionalidade de uma classe
    @GetMapping("/test")
    public String firstMessage() {
        return "Working";
    }

}
