package com.cognizant.cartservice.service;

import java.util.List;

import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.model.MenuItem;

public interface CartService {

	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException;
	public void removeCartItem(int userId, int menuItemId);

	public void addCartItem(int userId,int menuItemId);
}
