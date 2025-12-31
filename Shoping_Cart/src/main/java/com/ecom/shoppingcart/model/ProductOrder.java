package com.ecom.shoppingcart.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderId;
	private LocalDate orderDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserDtls user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	private Integer quantity;
	private Double price;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private OrderAddress address;
}
