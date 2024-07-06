package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="collection", nullable=false)
	private String collection;
	
	@Column(name="description", nullable=false, columnDefinition="TEXT")
	private String description;
	
	@Column(name="colour", nullable=false)
	private String colour;
	
	@Column(name="plating", nullable=false)
	private String plating;
	
	@Column(name="weight", nullable=false)
	private Double weight;
	
	@Column(name="img_filename", nullable=false)
	private String imgFilename;
	
	@Column(name="price", nullable=false)
	private Double price;
	
	@Column(name="stock", nullable=false)
	private Integer stock;

	
	public Product() {}


	public Product(String description, String collection, String colour, String plating, Double weight,
			String imgFilename, Double price, Integer stock) {
		super();
		this.description = description;
		this.collection = collection;
		this.colour = colour;
		this.plating = plating;
		this.weight = weight;
		this.imgFilename = imgFilename;
		this.price = price;
		this.stock = stock;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCollection() {
		return collection;
	}


	public void setCollection(String collection) {
		this.collection = collection;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getPlating() {
		return plating;
	}


	public void setPlating(String plating) {
		this.plating = plating;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public String getImgFilename() {
		return imgFilename;
	}


	public void setImgFilename(String imgFilename) {
		this.imgFilename = imgFilename;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
