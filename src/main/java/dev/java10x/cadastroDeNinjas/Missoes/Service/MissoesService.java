package dev.java10x.cadastroDeNinjas.Missoes.Service;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.cadastroDeNinjas.Missoes.Repository.MissoesRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    public MissoesRepository missoesRepository;


    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel missoesId(long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    public void deletarMissoes(long id){
        missoesRepository.deleteById(id);
        System.out.println("Missão deletada ");
    }

    public MissoesModel missoesAtualizada (long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

}
