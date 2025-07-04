package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// Entity tranforma uma classe em umma entidade do BD

@Entity
@Table(name = "TB_CADASTRO")
public class NinjaModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String email;

   private int idade;

   //@ManytoOne | um ninja tem uma unica Missão
   @ManyToOne
   @JoinColumn(name = "missoes_id") // chave estrangeira
   private MissoesModel missoes;

    public NinjaModel() {
    }



    public NinjaModel(String name, String email, int idade) {
        this.name = name;
        this.email = email;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
