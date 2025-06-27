package dev.java10x.cadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninja")
public class Controller {


    @GetMapping
    public String geralRota(){
        return "Rota geral ";
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Mensagem de rota boas vindas ";
    }



}
