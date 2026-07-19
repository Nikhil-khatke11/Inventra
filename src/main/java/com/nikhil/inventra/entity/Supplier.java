package com.nikhil.inventra.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "supplier")
public class Supplier {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
		
		@NotBlank
		private String name;
		
		@Email
		private String email;
	
		private String phoneNumber;
		
		private String address;
		             
		private LocalDateTime createdAt;
		
		private LocalDateTime updatedAt;
		
		@OneToMany(mappedBy = "supplier")
		private List<Product> products;

		public Supplier() {
			super();
		}

		public Supplier(String name, String email, String phoneNumber, String address, LocalDateTime createdAt,
				LocalDateTime updatedAt) {
			super();
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		
		@PrePersist
		public void onCreate() {
			this.createdAt = LocalDateTime.now();
			this.updatedAt = LocalDateTime.now();
		}
		
		@PreUpdate
		public void onUpdate() {
			this.updatedAt = LocalDateTime.now();
		}
		
}
