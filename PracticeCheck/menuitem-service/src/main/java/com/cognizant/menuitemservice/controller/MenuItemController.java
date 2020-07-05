package com.cognizant.menuitemservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.service.MenuItemServiceImpl;

@RestController
@RequestMapping("menu-items")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	MenuItemServiceImpl menuItemServiceImpl;
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		return menuItemServiceImpl.getMenuItem(id);
	}
	
	@GetMapping("")
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemServiceImpl.getMenuItemListCustomer();
	}
	
	@PutMapping("/edit/{id}")
	public void modifyMenuItem(@PathVariable long id,@RequestBody MenuItem menuItem) { 
		LOGGER.info("START modify");
		menuItemServiceImpl.modifyMenuItem(id,menuItem);
		LOGGER.info("END modify");
		return;
	}
	
	@PutMapping("/add")
	public void addMenuItem(@RequestBody MenuItem menuItem) {
		menuItemServiceImpl.addMenuItem(menuItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMenuItem(@PathVariable long id) {
		menuItemServiceImpl.deleteMenuItem(id);
		
	}
}
