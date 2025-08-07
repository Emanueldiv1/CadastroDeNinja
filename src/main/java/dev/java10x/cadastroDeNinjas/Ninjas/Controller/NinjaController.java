package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
       NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body("Ninja criado com sucesso: " + novoNinja.getName() + " ID: " + novoNinja.getId());

    }


    //Mostrar td os ninja
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> todosNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


    //Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> NinjasPorID(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não existe em nossos registros");
        }
    }

    //Alterar dados ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizar){
        NinjaDTO ninjaUP = ninjaService.listarNinjaId(id);
        if (ninjaUP!= null){
            NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninjaAtualizar);
            return ResponseEntity.ok(ninjaAtualizado);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja Informado não existe");
        }
    }

    //Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaID(@PathVariable Long id){
       if (ninjaService.listarNinjaId(id) != null){
           ninjaService.deletarNinja(id);
           return ResponseEntity.ok("Ninja com ID: " + id + " Deletado com sucesso");

       }
       else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com ID: " + id + " não existe" );
       }
    }


}
