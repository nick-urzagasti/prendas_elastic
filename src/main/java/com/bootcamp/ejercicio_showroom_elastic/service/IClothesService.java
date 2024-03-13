package com.bootcamp.ejercicio_showroom_elastic.service;



import com.bootcamp.ejercicio_showroom_elastic.dto.request.PrendaRequDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.ResponseDTO;

import java.util.List;

public interface IClothesService {
    List<PrendaRespDto> getAllClothes();
    PrendaRespDto getClothesByCode(String code);
    List<PrendaRespDto> getClothesBySize(String size);
    PrendaRespDto addPrenda(PrendaRequDto requDto);
    PrendaRespDto updatePrenda(String id, PrendaRequDto requDto);
    List<PrendaRespDto> getClothesByWord(String word);

    ResponseDTO deleteClothesById(String id);
}
