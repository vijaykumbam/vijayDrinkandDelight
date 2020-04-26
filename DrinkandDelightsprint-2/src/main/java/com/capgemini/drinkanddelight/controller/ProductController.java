package com.capgemini.drinkanddelight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinkanddelight.entity.DistributorEntity;
import com.capgemini.drinkanddelight.entity.ProductOrderEntity;
import com.capgemini.drinkanddelight.exception.ProductOrderEntityException;
import com.capgemini.drinkanddelight.service.ProductOrderEntityServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductOrderEntityServiceInterface productorderentityserviceinterface;
	
	/*
	 * This is a PostMethod(Http) is used to add the entity in the database.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : ResponseEntity<String>
	 * parameters: ProductOrderEntity(Class)
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@PostMapping("/addProductOrderEntity")
	public ResponseEntity<String> addProductOrderEntity(@RequestBody ProductOrderEntity productorderentity)
	{
		productorderentityserviceinterface.addProductOrderEntity(productorderentity);
		return new ResponseEntity<String>("productorderentity Added",HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) is used to get list of entities from the database.
	 * Method 	 : getListOfProductOrderEntity
	 * Type 	 : ResponseEntity
	 * parameters: -
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@GetMapping("/getListOfProductOrderEntity")
    public ResponseEntity<List<ProductOrderEntity>> getListOfProductOrderEntity()
	{
			List<ProductOrderEntity> list = productorderentityserviceinterface.getListOfProductOrderEntity();
			return new ResponseEntity<List<ProductOrderEntity>>(list,HttpStatus.OK);
	}
	
	
	/*
	 * This is a DeleteMethod(Http) by "OrderId" is used to delete the entity from the database.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : ResponseEntity
	 * parameters: orderId
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@DeleteMapping("/deleteProductOrderEntity/{orderId}")
	public ResponseEntity<Boolean> deleteProductOrderEntity(@PathVariable("orderId") String orderId) 
	{
		Boolean status =  productorderentityserviceinterface.deleteProductOrderEntity(orderId);
		if(!status) throw new ProductOrderEntityException("Entity Not found ");
		return new ResponseEntity<Boolean>(status,HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) by "OrderId" is used to get the entity from the database.
	 * Method 	 : getProductbyId
	 * Type 	 : ResponseEntity
	 * parameters: orderId
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */	
	@GetMapping("/getProductbyId/{orderId}")
	public ResponseEntity<ProductOrderEntity> getProductbyId(@PathVariable String orderId) 
	{
		ProductOrderEntity list = productorderentityserviceinterface.findByOrderId(orderId);
		return new ResponseEntity<ProductOrderEntity>(list,HttpStatus.OK);
	}
	
	/* Hard-Code
	 * This is a GetMethod(Http) by using "distributorId" is used to fetch the delivery status of particular distributorId.
	 * Method 	 : display
	 * Type 	 : ResponseEntity<List<String>>
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */	
	@GetMapping("/display/{id}")
	 public ResponseEntity<List<String>> display(@PathVariable String id)
	{
		List<String> list = productorderentityserviceinterface.displayOrder(id);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}

	/* Json Format
	 * This is a GetMethod(Http) by using "distributorId" is used to fetch the delivery status of particular distributorId.
	 * Method 	 : display1
	 * Type 	 : ResponseEntity<List<ProductOrderEntity>>
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */
	
	@GetMapping("/display1/{orderId}")
	public ResponseEntity<List<ProductOrderEntity>> display1(@PathVariable String orderId) 
	{
		List<ProductOrderEntity> list = productorderentityserviceinterface.displayOrder1(orderId);
		return new ResponseEntity<List<ProductOrderEntity>>(list,HttpStatus.OK);
	}
	
}
