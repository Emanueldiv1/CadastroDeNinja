package dev.java10x.cadastroDeNinjas.Missoes.DTO;

import dev.java10x.cadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissoesDTO {

    private Long id;

    private String nome;

    private String dificuldade;

    private String descricao;

    private List<NinjaDTO> ninja;
}
