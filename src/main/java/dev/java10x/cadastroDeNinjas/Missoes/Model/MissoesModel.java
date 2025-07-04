package dev.java10x.cadastroDeNinjas.Missoes.Model;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_MISSOES")
@NoArgsConstructor
@AllArgsConstructor
@Data // |Lombook/@Data|  Criar todos os get/set
public class MissoesModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;


    // OneToMany | uma missão pode ter uma lista de ninja
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel>  ninja;

}
