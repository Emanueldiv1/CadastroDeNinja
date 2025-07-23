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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }


    //Mostrar td os ninja
    @GetMapping("/listar")
    public List<NinjaModel> todosNinjas(){
        return ninjaService.listarNinjas();
    }


    //Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel NinjasPorID(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);
    }

    //Alterar dados ninjas
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable long id, @RequestBody NinjaModel ninjaAtualizar){
        return ninjaService.atulizarNinja(id, ninjaAtualizar);
    }

    //Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaID(@PathVariable Long id){
       ninjaService.deletarNinja(id);
    }


}
