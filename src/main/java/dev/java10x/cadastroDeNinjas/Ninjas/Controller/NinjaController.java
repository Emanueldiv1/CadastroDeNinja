package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    public NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public String geralRota(){
        return "Rota geral ";
    }

//    @GetMapping("/boasvindas")
//    public String boasVindas(){
//        return "Mensagem de rota boas vindas ";
//    }


    //Add ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }


    //Mostrar td os ninja
    @GetMapping("/listar")
    public List<NinjaModel> todosNinjas(){
        return ninjaService.listarNinjas();
    }


    //Mostrar ninja por ID
    @GetMapping("/listarId")
    public String todosNinjasPorID(){
        return "ninja por ID";
    }

    //Alterar dados ninjas
    @PutMapping("/alterarId")
    public String alterarNinja(){
        return "ninja alterado";
    }

    //Deletar ninja
    @DeleteMapping("/deletarId")
    public String deletarNinjaID(){
        return "NINJA EXCLUIDO";
    }


}
