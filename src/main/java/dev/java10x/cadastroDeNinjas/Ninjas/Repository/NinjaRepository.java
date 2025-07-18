package dev.java10x.cadastroDeNinjas.Ninjas.Repository;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
