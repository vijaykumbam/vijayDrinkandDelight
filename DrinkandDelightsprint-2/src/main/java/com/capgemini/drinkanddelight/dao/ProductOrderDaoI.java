package com.capgemini.drinkanddelight.dao;

import java.util.List;

import com.capgemini.drinkanddelight.entity.ProductOrderEntity;

public interface ProductOrderDaoI{

	public void addProductOrderEntity(ProductOrderEntity productorderentity);
	public List<ProductOrderEntity> getListOfProductOrderEntity();
	public ProductOrderEntity findByOrderId(String orderId);
	public Boolean deleteProductOrderEntity(String orderId);
	
	public List<ProductOrderEntity> displayProductOrder(String distibutorId);
	
	
	/*
	 * HardCoding 
	 */
	public List<String> displayOrder(String id);
	
	/*
	 * Json Format 
	 */
	public List<ProductOrderEntity> displayOrder1(String id);
}
