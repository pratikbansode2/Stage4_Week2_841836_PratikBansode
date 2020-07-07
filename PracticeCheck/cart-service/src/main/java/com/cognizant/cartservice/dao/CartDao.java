package com.cognizant.cartservice.dao;

import java.util.List;

import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.model.MenuItem;

public interface CartDao {

//	public void addCartItem(String userId, long menuItemId);
//	public List<MenuItem> getAllCartItems(String userId);
//	public void removeCartItem(String userId, long menuItemId);
//	
	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException;
	public void removeCartItem(int userId, int menuItemId);
	
	public void addCartItem(int userId,int menuItemId);

}
