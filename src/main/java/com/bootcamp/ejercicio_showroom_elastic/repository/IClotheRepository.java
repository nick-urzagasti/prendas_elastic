package com.bootcamp.ejercicio_showroom_elastic.repository;

import com.bootcamp.ejercicio_showroom_elastic.domain.Prenda;
import com.bootcamp.ejercicio_showroom_elastic.domain.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface IClotheRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findAll();
    Optional<Prenda> findByCodigo(String codigo);
    List<Prenda> findPrendasByTalle(String talle);
    List<Prenda> findPrendasByNombreContainsIgnoreCase(String word);
}
