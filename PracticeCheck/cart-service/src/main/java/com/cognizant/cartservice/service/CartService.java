package com.cognizant.cartservice.service;

import java.util.List;

import com.cognizant.cartservice.exception.CartEmptyException;

public interface CartService {

	public List<Integer> getAllCartItems(int userId) throws CartEmptyException;
	public void removeCartItem(int userId, int menuItemId);

	public void addCartItem(int userId,int menuItemId);
}
