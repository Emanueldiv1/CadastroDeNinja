package dev.java10x.cadastroDeNinjas.Missoes.Controller;


import dev.java10x.cadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.cadastroDeNinjas.Missoes.Service.MissoesService;
import dev.java10x.cadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    private MissoesService missoesService;

    public  MissoesControler(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    //--------------------------------------------------------------//-----------------------------------

    //Add missoes
    //Post -- Mandar uma requsição para crias as missoes
    @PostMapping("/criar")
    public ResponseEntity<?> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO missoesCriada = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Sua missão foi criada com sucesso" + " ID: " + missoesCriada.getId()
                        + "Nome: " + missoesCriada.getNome());
    }


    //Mostrar td os missoes
    //Get -- Mandar uma requsição para mostrar as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> todasMissoes(){
       List<MissoesDTO> missoesDTO = missoesService.listarMissoes();
       return ResponseEntity.ok(missoesDTO);
    }


    //Mostrar missoes por ID
    //Get -- Mandar uma requsição para mostrar as missoes por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable long id){
        MissoesDTO missoesID = missoesService.listarMissoesId(id);

        if (missoesID != null){
            return ResponseEntity.ok(missoesID);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não encontrada");
        }

    }


    //Alterar dados missoess
    //Put -- Mandar uma requsição para alterar as Missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable long id, @RequestBody MissoesDTO missaoAtualizar){
        MissoesDTO missoesAtualizando = missoesService.listarMissoesId(id);
        if (missoesAtualizando != null){
            MissoesDTO MissoesUP =  missoesService.missoesAtualizada(id, missaoAtualizar);
            return ResponseEntity.ok(MissoesUP);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: "  + id + " não encontrada no banco de dados");
        }

    }

    //Deletar missoes
    // Deletar na maioria das vezes tem que ser um metodo void
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoID(@PathVariable long id){
        if (missoesService.listarMissoesId(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " Deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não existe" );
        }
    }
}
