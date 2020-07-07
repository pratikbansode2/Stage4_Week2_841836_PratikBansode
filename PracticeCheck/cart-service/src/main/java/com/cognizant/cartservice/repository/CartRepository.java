package com.cognizant.cartservice.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.model.Cart;

import feign.Param;

@Repository
public interface CartRepository extends JpaRepositoryImplementation<Cart, Integer> {
	
	//Fetch items by user_id
		@Query(nativeQuery = true, value="SELECT * from cart uc WHERE uc.us_id = :user_id")
		public ArrayList<Cart> findByUserId(@Param("user_id") int user_id); 

		//Fetch count of items in cart
		@Query(nativeQuery = true, value="SELECT count(*) from cart uc WHERE uc.us_id = :user_id")
		public int findUserIdCount(@Param("user_id") int user_id);
	
}
