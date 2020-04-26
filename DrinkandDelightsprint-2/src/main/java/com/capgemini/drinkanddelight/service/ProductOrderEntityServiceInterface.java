package com.capgemini.drinkanddelight.service;

import java.util.List;

import com.capgemini.drinkanddelight.entity.ProductOrderEntity;

public interface ProductOrderEntityServiceInterface {

	public ProductOrderEntity addProductOrderEntity(ProductOrderEntity productorderentity);
	public List<ProductOrderEntity> getListOfProductOrderEntity();
	public ProductOrderEntity findByOrderId(String orderId);
	public Boolean deleteProductOrderEntity(String orderId);
	public List<ProductOrderEntity> displayProductOrder (String distibutorId);
	public List<String> displayOrder(String id);
	List<ProductOrderEntity> displayOrder1(String id);
}
