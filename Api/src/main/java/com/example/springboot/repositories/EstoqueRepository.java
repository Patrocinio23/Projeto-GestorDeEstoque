
package com.example.springboot.repositories;


import com.example.springboot.models.EstoqueModel;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
     @Query(value = "SELECT e.id_estoque, e.id_product, p.name, e.quantidade, p.caracteristicas " +
                   "FROM tb_estoque e " +
                   "INNER JOIN tb_products p ON e.id_product = p.id_product " +
                  "WHERE (:idProduct IS NULL OR e.id_product = :idProduct)", 
       nativeQuery = true) 
           
    List<Object[]> findProductDetailsByProductId(@Param("idProduct") Long idProduct);

     Optional<EstoqueModel> findByProduct_IdProduct(Integer idProduct);

    
}
   

