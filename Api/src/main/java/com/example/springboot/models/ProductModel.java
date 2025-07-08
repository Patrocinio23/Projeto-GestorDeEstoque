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
@Table(name = "tb_products")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
       
	private Long idProduct;
	private String name;
	private String caracteristicas;

	@ManyToOne
    @JoinColumn(name = "id_categoria") // essa será a chave estrangeira no banco
    private CategoriaModel categoria;

	
    public void setCategoria(CategoriaModel categoria) {
    this.categoria = categoria;
    }
 
	public Long getIdProduct() {
		return idProduct;
	}

	public void setidProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


}
