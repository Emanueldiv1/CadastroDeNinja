package dev.java10x.cadastroDeNinjas.Missoes.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    //Add missoes
    //Post -- Mandar uma requsição para crias as missoes
    @PostMapping("/add")
    public String criarMissao(){
        return "missão criada";
    }


    //Mostrar td os missoes
    //Get -- Mandar uma requsição para mostrar as missoes
    @GetMapping("/allmissoes")
    public String todasMissoes(){
        return "Todos missoes";
    }


    //Mostrar missoes por ID
    //Get -- Mandar uma requsição para mostrar as missoes por ID
    @GetMapping("/missoesID")
    public String todasMissoesPorID(){
        return "missoes por ID";
    }

    //Alterar dados missoess
    //Put -- Mandar uma requsição para alterar as Missoes
    @PutMapping("/alterarmissoes")
    public String alterarMissoes(){
        return "missoes alterado";
    }

    //Deletar missoes
    //Delete -- Mandar uma requsição para deletar as missoes
    @DeleteMapping("/deletarmissaoID")
    public String deletarMissaoID(){
        return "MISSÃO EXCLUIDO";
    }
}
