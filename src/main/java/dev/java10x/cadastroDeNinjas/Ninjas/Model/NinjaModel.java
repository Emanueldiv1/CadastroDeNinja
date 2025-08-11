package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// Entity tranforma uma classe em umma entidade do BD

@Entity
@Table(name = "TB_CADASTRO")
@NoArgsConstructor
@AllArgsConstructor
@Data // |Lombook/@Data|  Criar todos os get/set
@ToString(exclude = "missoes" )
public class NinjaModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @Column(unique = true)
   private String email;

   @Column(name = "img_url")
   private String imgUrl;

   private int idade;

   @Column(name = "rank")
   private String rank;

   //@ManytoOne | um ninja tem uma unica Missão
   @ManyToOne
   @JoinColumn(name = "missoes_id") // chave estrangeira
   private MissoesModel missoes;


}
