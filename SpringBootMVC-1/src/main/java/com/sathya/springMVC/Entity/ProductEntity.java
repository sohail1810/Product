package com.sathya.springMVC.Entity;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class ProductEntity
{
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String brand;
	private String madeIn;
	private int quantity;
	private double Price;
	private double discountRate;
	private double taxRate;
	private double discountPrice;
	private double offerPrice;
	private double finalPrice;
	private double taxPrice;
	private double stockValue;
	
	

}
