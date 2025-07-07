
package com.example.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "tb_estoque")
public class EstoqueModel extends RepresentationModel<EstoqueModel> implements Serializable{
    private static final long serialVersionUID = 1L;

        @Id
	    @GeneratedValue(strategy=GenerationType.SEQUENCE)
        private Integer idEstoque;
	    private Integer idProduct;
        public Integer quantidade;
        
        
    public Integer getidEstoque() {
		return idEstoque;
	}

	public void setidEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
        }

	public Integer getidProduct() {
		return idProduct;
	}

	public void setidProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
        
      
}

    

