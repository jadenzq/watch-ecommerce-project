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
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false, columnDefinition="TEXT")
	private String description;
	
	@Column(name="collection", nullable=false)
	private String collection;
	
	@Column(name="colour", nullable=false)
	private String colour;
	
	@Column(name="plating", nullable=false)
	private String plating;
	
	@Column(name="weight", nullable=false)
	private String weight;
	
	@Column(name="img_url", nullable=false)
	private String imgUrl;
	
	@Column(name="price", nullable=false)
	private Double price;
	
	@Column(name="stock", nullable=false)
	private Integer stock;

	
	public Product() {}


	public Product(String name, String description, String collection, String colour, String plating, String weight,
			String imgUrl, Double price, Integer stock) {
		super();
		this.name = name;
		this.description = description;
		this.collection = collection;
		this.colour = colour;
		this.plating = plating;
		this.weight = weight;
		this.imgUrl = imgUrl;
		this.price = price;
		this.stock = stock;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
