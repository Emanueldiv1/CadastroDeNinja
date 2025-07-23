package dev.java10x.cadastroDeNinjas.Missoes.Controller;


import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.cadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    public MissoesService missoesService;

    public  MissoesControler(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    //--------------------------------------------------------------//-----------------------------------

    //Add missoes
    //Post -- Mandar uma requsição para crias as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }


    //Mostrar td os missoes
    //Get -- Mandar uma requsição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel>todasMissoes(){
       return missoesService.listarMissoes();
    }


    //Mostrar missoes por ID
    //Get -- Mandar uma requsição para mostrar as missoes por ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable long id){
        return missoesService.missoesId(id);
    }


    //Alterar dados missoess
    //Put -- Mandar uma requsição para alterar as Missoes
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissoes(@PathVariable long id, @RequestBody MissoesModel missaoAtualizadar){
        return missoesService.missoesAtualizada(id, missaoAtualizadar);

    }

    //Deletar missoes
    // Deletar na maioria das vezes tem que ser um metodo void
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoID(@PathVariable long id){
        missoesService.deletarMissoes(id);
    }
}
