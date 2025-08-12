package dev.java10x.cadastroDeNinjas.Ninjas.UI;

import dev.java10x.cadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    public final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String todosNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // tem que retornar o nome da pag que renderiza
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaID(@PathVariable Long id){
       ninjaService.deletarNinja(id);
       return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String NinjasPorID(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjaId(id);

        if (ninja != null){
            model.addAttribute("ninjas", ninja);
            return "detalhesNinja";
        }
        else{
            model.addAttribute("Mensagem", "Ninja não encontrado" );
            return "listarNinjas";
        }
    }

}
