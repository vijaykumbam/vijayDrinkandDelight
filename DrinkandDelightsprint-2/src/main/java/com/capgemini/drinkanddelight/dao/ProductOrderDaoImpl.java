package com.capgemini.drinkanddelight.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.ProductOrderEntity;


@Repository
@Transactional
public class ProductOrderDaoImpl implements ProductOrderDaoI{
	
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	@Override
	public void addProductOrderEntity(ProductOrderEntity productorderentity) {
		entityManager.persist(productorderentity);
	}
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : getListOfProductOrderEntity()
	 * Type 	 : ProductOrderEntity
	 * parameters: -
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	public List<ProductOrderEntity> getListOfProductOrderEntity(){
		String Qstr="SELECT productorderentity from ProductOrderEntity productorderentity";
		TypedQuery<ProductOrderEntity> query=entityManager.createQuery(Qstr,ProductOrderEntity.class);
		return query.getResultList();
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
		return entityManager.find(ProductOrderEntity.class, orderId);
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
		
		ProductOrderEntity obj =entityManager.find(ProductOrderEntity.class, orderId);
		if(obj !=null)
		{
			entityManager.remove(obj);
			return true;
		}
		else 
		return false;
	}
	
	/*
	 * This method is used to find the list of orders by one distributor by entering the supplierId and DeliveryStatus.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : VijayKumbam
	 * Date 	 : 20/04/2020
	 */
	
	public List<ProductOrderEntity> displayProductOrder(String distibutorId)
	{
		TypedQuery<ProductOrderEntity> query = entityManager.createQuery( "SELECT p.deliveryStatus FROM ProductOrderEntity p WHERE p.distributorId =?1", ProductOrderEntity.class);
		System.out.println("qwertyu");
		//query.setParameter("distributorId",distibutorId).getResultList();
		return query.setParameter(1, distibutorId).getResultList();
	}
	
	/*
	 * Hard Coding to find the delivery status by using the distributor Id
	 * Method 	 : displayOrder
	 * Type 	 : List<String> 
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */
	public List<String> displayOrder(String id)
	{
		String Qstr="SELECT productorderentity from ProductOrderEntity productorderentity";
		TypedQuery<ProductOrderEntity> query=entityManager.createQuery(Qstr,ProductOrderEntity.class);
		List<ProductOrderEntity>result = query.getResultList();
		
		List<String> res = new ArrayList<String>();
		
		
		Iterator<ProductOrderEntity> itr =result.iterator();
		 while(itr.hasNext()) 
		 {
	         ProductOrderEntity element = itr.next();
	         if(element.getDistributorId().contentEquals(id))
	         {
	        	System.out.println("DistributorId ="+id+" " +"deliveryStatus="+element.getDeliveryStatus());
	        	res.add(element.getDistributorId()+" " + element.getOrderId()+" "+element.getDateOfOrder()+" "+element.getDateOfDelivery()+" "+element.getDeliveryStatus());
	        	//return element.getDeliveryStatus();
	         }
	      } 
		return res;	
	}
	
	/* Json Format
	 * This method is used to give the list of deliveryStatus and OrderId by using the distributorId
	 * Method 	 : displayOrder1
	 * Type 	 : List<ProductOrderEntity> 
	 * parameters: id 
	 * Author 	 : VijayKumbam
	 * Date 	 : 21/04/2020
	 */
	public List<ProductOrderEntity> displayOrder1(String id)
	{
		String Qstr="SELECT productorderentity from ProductOrderEntity productorderentity";
		TypedQuery<ProductOrderEntity> query=entityManager.createQuery(Qstr,ProductOrderEntity.class);
		List<ProductOrderEntity>result = query.getResultList();
		
		List<ProductOrderEntity> res = new ArrayList<ProductOrderEntity>();
		
		
		Iterator<ProductOrderEntity> itr =result.iterator();
		 while(itr.hasNext()) 
		 {
	         ProductOrderEntity element = itr.next();
	         if(element.getDistributorId().contentEquals(id))
	         {
	        	System.out.println("DistributorId ="+id+" " +"deliveryStatus="+element.getDeliveryStatus());
	        	res.add(element);
	        	//return element.getDeliveryStatus();
	         }
	      } 
		return res;	
	}
	
}
