package com.guia.practica.repository;

import com.guia.practica.model.Factura;
import com.guia.practica.model.ItemFactura;
import com.guia.practica.model.Usuario;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemFacturaRepository extends GenericRepository<ItemFactura, Long> {

    @Query(value = "SELECT * " +
            "FROM item_factura " +
            "WHERE id_factura = :idfactura", nativeQuery = true)
    List<ItemFactura> itemsFact(@Param("idfactura") Long idfactura);
}
