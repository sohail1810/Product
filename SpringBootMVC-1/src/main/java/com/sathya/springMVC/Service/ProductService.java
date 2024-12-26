package com.sathya.springMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathya.springMVC.Entity.ProductEntity;
import com.sathya.springMVC.ProductModel.ProductModel;
import com.sathya.springMVC.Repository.ProductRepository;

import lombok.Setter;

@Service
@Setter
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	private ProductEntity productEntity;
	private Object productModel;
	private Optional<ProductEntity> product;
	public void saveProductDetails(ProductModel productModel)
	{
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		double offerPrice;
		offerPrice=productModel.getPrice()-discountPrice;
		double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		double taxPrice;
		taxPrice=productModel.getPrice()*productModel.getTaxRate()/100;
		double finalPrice;
		finalPrice=offerPrice+taxPrice;
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountRate(productModel.getDiscountRate());
		productEntity.setTaxRate(productModel.getTaxRate());
		productEntity.setOfferPrice(offerPrice);
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setFinalPrice(finalPrice);
		productEntity.setTaxPrice(taxPrice);
		productEntity.setStockValue(stockValue);
		productRepository.save(productEntity);
		
		
	}
	public List<ProductEntity> getAllProducts()
	{
		List<ProductEntity>products=productRepository.findAll();
		return products;
	}
	public ProductEntity searchById(Long id)
	{
		Optional<ProductEntity> optionalData= productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
		
		
	}
	
	public void deleteProductById(Long id)
	{
		productRepository.deleteById(id);
		
		
	}
	
	public ProductModel editProducts( Long id)
	{
		Optional<ProductEntity> optionalData=productRepository.findById(id);	
		ProductModel productModel = new ProductModel();
		if(optionalData.isPresent())
		{
			ProductEntity productEntity=optionalData.get();
		productModel.setName(productEntity.getName());
		productModel.setBrand(productEntity.getBrand());
		productModel.setMadeIn(productEntity.getMadeIn());
		productModel.setPrice(productEntity.getPrice());
		productModel.setQuantity(productEntity.getQuantity());
		productModel.setDiscountRate(productEntity.getDiscountRate());
		productModel.setTaxRate(productEntity.getTaxRate());
		
		return productModel;
		}
		else
		{
			return null;
		}
		
		
	}
	public void editProducts(long id, ProductModel productModel) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> op=productRepository.findById(id);
		if(op.isPresent())
		{
			double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
			double offerPrice;
			offerPrice=productModel.getPrice()-discountPrice;
			double stockValue;
			stockValue=productModel.getPrice()*productModel.getQuantity();
			double taxPrice;
			taxPrice=productModel.getPrice()*productModel.getTaxRate()/100;
			double finalPrice;
			finalPrice=offerPrice+taxPrice;
			ProductEntity entity=op.get();
			entity.setName(productModel.getName());
			entity.setBrand(productModel.getBrand());
			entity.setMadeIn(productModel.getMadeIn());
			entity.setPrice(productModel.getPrice());
			entity.setQuantity(productModel.getQuantity());
			entity.setDiscountRate(productModel.getDiscountRate());
			entity.setTaxRate(productModel.getTaxRate());
			entity.setOfferPrice(offerPrice);
			entity.setDiscountPrice(discountPrice);
			entity.setFinalPrice(finalPrice);
			entity.setTaxPrice(taxPrice);
			entity.setStockValue(stockValue);
			productRepository.save(entity);
		}
		
		}
	
	

}
