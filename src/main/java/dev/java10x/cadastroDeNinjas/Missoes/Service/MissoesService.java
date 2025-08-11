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
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //------------------------------------------------------------------------------------------------------------

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(m -> missoesMapper.map(m))
                .collect(Collectors.toList());

    }

    public MissoesDTO listarMissoesId(long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper :: map).orElse(null);
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);// tranformas os dados de MissoesDTO -> para MissoesModel
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes); // MissoesModel --> MissoesDTO

    }

    public void deletarMissoes(long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO missoesAtualizada (long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSave = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSave);
        }
        return null;

        /*if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;*/
    }

}
