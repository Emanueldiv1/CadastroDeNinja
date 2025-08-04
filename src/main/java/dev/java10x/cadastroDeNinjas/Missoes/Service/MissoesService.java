package dev.java10x.cadastroDeNinjas.Missoes.Service;

import dev.java10x.cadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.cadastroDeNinjas.Missoes.Mapper.MissoesMapper;
import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.cadastroDeNinjas.Missoes.Repository.MissoesRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel missoesId(long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);// tranformas os dados de MissoesDTO -> para MissoesModel
        missoesDTO.getDificuldade().toUpperCase();
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes); // MissoesModel --> MissoesDTO

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
