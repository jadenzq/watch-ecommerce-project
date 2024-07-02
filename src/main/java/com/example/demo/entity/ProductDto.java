package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	
	private MultipartFile imgFile;
	private String name;
	private String description;
	private Double price;
	private Integer stock;
	private String collection;
	private String colour;
	private String plating;
	private String weight;
	
	public ProductDto() {}

	public ProductDto(MultipartFile imgFile, String name, String description, Double price, Integer stock,
			String collection, String colour, String plating, String weight) {
		super();
		this.imgFile = imgFile;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.collection = collection;
		this.colour = colour;
		this.plating = plating;
		this.weight = weight;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
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

	
	
	
	
}
