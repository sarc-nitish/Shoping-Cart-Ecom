package com.ecom.shoppingcart.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	private String password;
	private String mobileNumber;
	private String address;
	private String city;
	private String state;
	private String pincode;

	private String profileImage;

	// ROLE_USER / ROLE_ADMIN
	private String role;

	private Boolean isEnable = true;
	private Boolean accountNonLocked = true;

	private Integer failedAttempt = 0;
	private LocalDateTime lockTime;
}
