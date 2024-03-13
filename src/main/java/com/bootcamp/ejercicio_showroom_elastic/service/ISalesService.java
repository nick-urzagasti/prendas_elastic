package com.bootcamp.ejercicio_showroom_elastic.service;

import com.bootcamp.ejercicio_showroom_elastic.dto.request.VentaReqDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_showroom_elastic.dto.response.VentaRespDto;
import com.bootcamp.ejercicio_showroom_elastic.domain.Prenda;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {

    List<VentaRespDto> getSalesOnDate(String date);

    VentaRespDto getSaleByNumber(Long number);

    List<VentaRespDto> getAllSales();

    VentaRespDto addVenta(VentaReqDto ventaReqDto);

    VentaRespDto updateVenta(Long id, VentaReqDto ventaReqDto);

    List<PrendaRespDto> getClothesBySaleNumber(Long number);

    ResponseDTO deleteSaleById(Long id);
}
