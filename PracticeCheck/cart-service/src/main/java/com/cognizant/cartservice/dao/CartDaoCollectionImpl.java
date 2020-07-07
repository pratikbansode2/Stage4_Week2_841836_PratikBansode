package com.cognizant.cartservice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.ExchangeServiceProxy.MenuItemExchangeServiceProxy;
import com.cognizant.cartservice.exception.CartEmptyException;
import com.cognizant.cartservice.exception.MenuItemNotFoundException;
import com.cognizant.cartservice.model.Cart;
import com.cognizant.cartservice.model.MenuItem;
import com.cognizant.cartservice.repository.CartRepository;

@Service
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	MenuItemExchangeServiceProxy proxyService;

	@Autowired
	CartRepository cartRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);

	@Override
	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		if (cartRepository.findUserIdCount(userId) == 0) {
			return null;
		}

		ArrayList<Cart> cartList = cartRepository.findByUserId(userId);
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		if (cartList != null) {
			for (Cart cart : cartList) {
				MenuItem menuItem = proxyService.findMenuItemById(cart.getC_id());
				menuItemList.add(menuItem);
			}
		}
		return menuItemList;

	}

	@Override
	public void removeCartItem(int userId, int menuItemId) {
		// TODO Auto-generated method stub
		MenuItem menuItem = proxyService.findMenuItemById(menuItemId);
		ArrayList<Cart> cartList = cartRepository.findByUserId(userId);
		Cart delCart = null;
		for (Cart cart : cartList) {
			if (cart.getC_id() == menuItemId) {
				delCart = cart;
			}

			if (delCart != null) {
				cartRepository.delete(delCart);
			}
		}
	}

	@Override
	public void addCartItem(int userId, int menuItemId) {
		// TODO Auto-generated method stub
		MenuItem item = proxyService.findMenuItemById(menuItemId);
		if (item == null) {
			throw new MenuItemNotFoundException();
		}

		Cart cart = new Cart(userId, menuItemId);
		cartRepository.save(cart);
	}

}
