package com.sathya.springMVC.ProductModel;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
public class ProductModel
{
	@NotBlank(message = "product name cannot be blank")
	private String name;
	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	@NotBlank(message = "product madeIn cannot be blank")
	private String madeIn;
	@Positive(message = "price must be greater than zero")
	private double price;
	@Min( value = 1, message = "quantity must be atleast 1")
	private int  quantity;
	@DecimalMax(value = "100.0", message = "discountRate cannot exceed 100")
	private double discountRate;
	@DecimalMax(value = "100.0", message="TaxRate cannot exceed 100")
	private double taxRate;
	
	
	}


