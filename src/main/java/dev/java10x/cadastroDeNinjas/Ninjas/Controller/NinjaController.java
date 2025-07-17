package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/ninja")
public class NinjaController {


    @GetMapping
    public String geralRota(){
        return "Rota geral ";
    }

//    @GetMapping("/boasvindas")
//    public String boasVindas(){
//        return "Mensagem de rota boas vindas ";
//    }


    //Add ninja
    @PostMapping("/add")
    public String criarNinja(){
        return "Ninja criado";
    }


    //Mostrar td os ninja
    @GetMapping("/allninjas")
    public String todosNinjas(){
        return "Todos ninja";
    }


    //Mostrar ninja por ID
    @GetMapping("/ninjaID")
    public String todosNinjasPorID(){
        return "ninja por ID";
    }

    //Alterar dados ninjas
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "ninja alterado";
    }

    //Deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaID(){
        return "NINJA EXCLUIDO";
    }


}
