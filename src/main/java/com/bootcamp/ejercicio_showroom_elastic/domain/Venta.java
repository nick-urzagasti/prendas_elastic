package com.bootcamp.ejercicio_showroom_elastic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "venta_prenda")
public class Venta {
    @Id
    String numero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    LocalDate fecha;
    Integer total;
    String medio_de_pago;
    @Field(type = FieldType.Nested, includeInParent = true)
    List<Prenda> prendas;
}
