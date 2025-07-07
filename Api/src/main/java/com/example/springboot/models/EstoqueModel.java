
package com.example.springboot.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class EstoqueModel extends RepresentationModel<EstoqueModel> implements Serializable{
    private static final long serialVersionUID = 1L;

        @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
        private Integer idEstoque;
        public Integer quantidade;

		@ManyToOne
        @JoinColumn(name = "id_product")
        private ProductModel produto;

        
        
        public Integer getidEstoque() {
		return idEstoque;
	}

	public void setidEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
        }

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
        
      
}

    

