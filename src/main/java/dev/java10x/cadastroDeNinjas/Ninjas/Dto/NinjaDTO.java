package dev.java10x.cadastroDeNinjas.Ninjas.Dto;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;

    private String name;

    private String email;

    private String imgUrl;

    private int idade;

    private String rank;

    private MissoesModel missoes;
}
