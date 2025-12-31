package com.ecom.shoppingcart.model;

import jakarta.persistence.*;
import lombok.*;

@Data   // 🔥 THIS IS THE KEY FIX
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private double price;

	private double discount;

	private double discountPrice;

	private int stock;

	private String image;

	private Boolean isActive = true;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
