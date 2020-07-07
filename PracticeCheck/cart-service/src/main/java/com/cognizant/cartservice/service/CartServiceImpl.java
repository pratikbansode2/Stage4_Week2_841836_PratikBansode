package com.cognizant.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cartservice.dao.CartDao;
import com.cognizant.cartservice.dao.CartDaoCollectionImpl;
import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.model.MenuItem;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDaoCollectionImpl cartDaoCollectionImpl;
	
//	public void addCartItem(String userId,long menuItemId) {
//		cartDao.addCartItem(userId, menuItemId);
//	}
//	
//	public List<MenuItem> getAllCartItems(String userId){
//		return cartDao.getAllCartItems(userId);
//	}
//	
//	public void deleteCartItem(String userId,long menuItemId) {
//		cartDao.removeCartItem(userId, menuItemId);
//	}

	@Override
	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		return cartDaoCollectionImpl.getAllCartItems(userId);
	}

	@Override
	public void removeCartItem(int userId, int menuItemId) {
		// TODO Auto-generated method stub
		
		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);
	}

	@Override
	public void addCartItem(int userId, int menuItemId) {
		// TODO Auto-generated method stub
		cartDaoCollectionImpl.addCartItem(userId, menuItemId);
	}
}
