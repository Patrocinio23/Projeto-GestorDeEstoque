
package com.example.springboot.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.EstoqueModel;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
   

     Optional<EstoqueModel> findByProduct_IdProduct(Integer idProduct);

    
}
   

