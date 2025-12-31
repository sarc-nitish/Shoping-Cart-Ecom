package com.ecom.shoppingcart.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class OrderRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String paymentType;
}
