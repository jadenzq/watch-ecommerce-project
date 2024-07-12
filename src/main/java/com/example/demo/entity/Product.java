package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

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
	private ArrayList<String> imgFilenames;
	
	@Column(name="price", nullable=false)
	private Double price;
	
	@Column(name="stock", nullable=false)
	private Integer stock;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> review;
	
	public Product() {}


	public Product(String collection, String description, String colour, String plating, Double weight,
			ArrayList<String> imgFilenames, Double price, Integer stock, List<Review> review) {
		super();
		this.collection = collection;
		this.description = description;
		this.colour = colour;
		this.plating = plating;
		this.weight = weight;
		this.imgFilenames = imgFilenames;
		this.price = price;
		this.stock = stock;
		this.review = review;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCollection() {
		return collection;
	}


	public void setCollection(String collection) {
		this.collection = collection;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public ArrayList<String> getImgFilenames() {
		return imgFilenames;
	}


	public void setImgFilenames(ArrayList<String> imgFilenames) {
		this.imgFilenames = imgFilenames;
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
	
	public List<Review> getReview() {
		return review;
	}


	public void setReview(List<Review> review) {
		this.review = review;
	}
	
}
