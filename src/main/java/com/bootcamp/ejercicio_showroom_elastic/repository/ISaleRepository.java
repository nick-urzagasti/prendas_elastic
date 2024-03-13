package com.bootcamp.ejercicio_showroom_elastic.repository;

import com.bootcamp.ejercicio_showroom_elastic.domain.Venta;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchAggregation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ISaleRepository extends ElasticsearchRepository<Venta, Long> {

}
