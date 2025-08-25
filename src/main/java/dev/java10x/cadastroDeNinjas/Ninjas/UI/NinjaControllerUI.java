package dev.java10x.cadastroDeNinjas.Ninjas.UI;

import dev.java10x.cadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja =  ninjaService.listarNinjaId(id);
        if (ninja !=null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }


    @GetMapping("/alterar/{id}")
    public String mostrarFormularioEdicao(@PathVariable long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        if (ninja == null) {
            return "redirect:/ninjas/ui/listar"; // se não achar, volta pra lista
        }
        model.addAttribute("ninja", ninja);
        return "editarNinja"; // nome do HTML
    }


    @PostMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable long id, @ModelAttribute("ninja") NinjaDTO ninjaForm) {
        NinjaDTO ninjaExistente = ninjaService.listarNinjaId(id);

        if (ninjaExistente != null) {
            // Só atualiza os campos que podem mudar
            ninjaExistente.setImgUrl(ninjaForm.getImgUrl());
            ninjaExistente.setName(ninjaForm.getName());
            ninjaExistente.setEmail(ninjaForm.getEmail());
            ninjaExistente.setIdade(ninjaForm.getIdade());
            ninjaExistente.setRank(ninjaForm.getRank());

            // NÃO mexe em missoes
            ninjaService.atualizarNinja(id, ninjaExistente);
        }

        return "redirect:/ninjas/ui/listar";
    }







}
