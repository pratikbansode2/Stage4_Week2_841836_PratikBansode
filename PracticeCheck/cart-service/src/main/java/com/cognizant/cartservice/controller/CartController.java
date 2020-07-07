package com.cognizant.cartservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.cartservice.model.MenuItem;
import com.cognizant.cartservice.service.CartServiceImpl;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable int userId,@PathVariable int menuItemId) {
		cartServiceImpl.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable int userId){
		return cartServiceImpl.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable int userId,@PathVariable int menuItemId) {
		cartServiceImpl.removeCartItem(userId, menuItemId);
	}
}
