package com.capgemini.drinkanddelight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinkanddelight.dao.ProductOrderDaoI;
import com.capgemini.drinkanddelight.entity.ProductOrderEntity;

@Service
@Transactional
public class ProductOrderEntityServiceImpl implements ProductOrderEntityServiceInterface {

	@Autowired 
	private ProductOrderDaoI productorderdaoi;


	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public ProductOrderEntity addProductOrderEntity(ProductOrderEntity productorderentity) {
		productorderdaoi.addProductOrderEntity(productorderentity);
		return productorderentity;
		
	}

	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : getListOfProductOrderEntity()
	 * Type 	 : ProductOrderEntity
	 * parameters: -
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public List<ProductOrderEntity> getListOfProductOrderEntity() {
		System.out.println("qwertyu");
		return productorderdaoi.getListOfProductOrderEntity();
	}

	/*
	 * This method is used to find the entity by the OrderId from the orderManagement Table.
	 * Method 	 : findByOrderId
	 * Type 	 : ProductOrderEntity(Class)
	 * parameters: OrderId
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public ProductOrderEntity findByOrderId(String orderId) {
		return productorderdaoi.findByOrderId(orderId);
	}

	/*
	 * This method is used to delete the entity from the OrderManagement table.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public Boolean deleteProductOrderEntity(String orderId) {
		
		return productorderdaoi.deleteProductOrderEntity(orderId);
		
	}
	/*
	 * This method is used to find the list of orders by one distributor by entering the supplierId and DeliveryStatus.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public List<ProductOrderEntity> displayProductOrder (String distibutorId)
	{
		return productorderdaoi.displayProductOrder(distibutorId);
	}

	/*
	 * Hard Coding to find the delivery status by using the distributor Id
	 * Method 	 : displayOrder
	 * Type 	 : List<String> 
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */
	@Override
	public List<String> displayOrder(String id) {
		return productorderdaoi.displayOrder(id);
	}

	/* Json Format
	 * This method is used to give the list of deliveryStatus and OrderId by using the distributorId
	 * Method 	 : displayOrder1
	 * Type 	 : List<ProductOrderEntity> 
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */
	@Override
	public List<ProductOrderEntity> displayOrder1(String id) {
		return productorderdaoi.displayOrder1(id);
	}
	
	
	
	
}
