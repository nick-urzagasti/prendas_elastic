package com.bootcamp.ejercicio_showroom_elastic.service;


import com.bootcamp.ejercicio_showroom_elastic.domain.Prenda;
import com.bootcamp.ejercicio_showroom_elastic.repository.IClotheRepository;
import com.bootcamp.ejercicio_showroom_elastic.dto.request.PrendaRequDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements IClothesService{
    private IClotheRepository clothesRepository;
    private ModelMapper mapper;
    public ClothesServiceImpl(IClotheRepository clothesRepository){
        this.clothesRepository = clothesRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<PrendaRespDto> getAllClothes() {
        return this.clothesRepository.findAll().stream()
                .map(prenda -> mapper.map(prenda, PrendaRespDto.class))
                .toList();
    }

    @Override
    public PrendaRespDto getClothesByCode(String code) {
        Optional<Prenda> prendaBuscada = this.clothesRepository.findByCodigo(code);
        if (prendaBuscada.isEmpty()) {
            throw new RuntimeException("La prenda con código" + code + "no existe");
        }
        return mapper.map(prendaBuscada.get(), PrendaRespDto.class);
    }

    @Override
    public PrendaRespDto addPrenda(PrendaRequDto requDto) {
        return mapper.map(clothesRepository.save(mapper.map(requDto, Prenda.class)), PrendaRespDto.class);
    }

    @Override
    public PrendaRespDto updatePrenda(String id, PrendaRequDto requDto) {
        Optional<Prenda> optPrenda = clothesRepository.findByCodigo(id);

        if (optPrenda.isEmpty()) {
            throw new RuntimeException("La prenda con id " + id + " no se puede actualizar porque no existe.");
        }

        optPrenda = Optional.of(mapper.map(requDto, Prenda.class));
        optPrenda.get().setCodigo(id);

        return mapper.map(clothesRepository.save(optPrenda.get()), PrendaRespDto.class);
    }

    @Override
    public List<PrendaRespDto> getClothesBySize(String talle) {
        List<Prenda> listaPrendas = clothesRepository.findPrendasByTalle(talle);
        return listaPrendas.stream().map(p -> mapper.map(p, PrendaRespDto.class)).toList();
    }


    @Override
    public ResponseDTO deleteClothesById(String id){
        Prenda prenda = this.clothesRepository.findByCodigo(id).get();
        clothesRepository.delete(prenda);
        return new ResponseDTO("Prenda eliminada con exito");
    }

    public List<PrendaRespDto> getClothesByWord(String word){
        return clothesRepository.findPrendasByNombreContainsIgnoreCase(word)
                .stream()
                .map(p -> mapper.map(p, PrendaRespDto.class))
                .toList();
    }
}
