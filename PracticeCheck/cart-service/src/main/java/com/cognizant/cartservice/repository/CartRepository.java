package com.cognizant.cartservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.model.Cart;

@Repository
public interface CartRepository extends JpaRepositoryImplementation<Cart, Integer> {
	
	@Query("select f.c_id from Cart f where us_id=?1")
	public List<Integer> getAllCartItems(int userId) throws CartEmptyException;
	
	@Modifying
	@Transactional
	@Query(value="delete from Cart f where f.us_id=?1 and f.c_id=?2", nativeQuery = true)
	public void removeCartItem(int userId, int menuItemId);

}
