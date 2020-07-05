package com.cognizant.menuitemservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.repository.MenuItemRepository;
import com.cognizant.menuitemservice.exception.MenuItemNotFoundException;
import com.cognizant.menuitemservice.model.MenuItem;

@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem= menuItemRepository.findById(menuItemId).orElseThrow(()->{throw new MenuItemNotFoundException();});
		return menuItem;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
     	List<MenuItem> menuItemListCustomer = menuItemRepository.findAll();
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(long menuItemId, MenuItem menuItem) {
		// TODO Auto-generated method stub
		MenuItem menuItemOld= menuItemRepository.findById(menuItemId).orElseThrow(()->{throw new MenuItemNotFoundException();});
		menuItemOld.setActive(menuItem.isActive());
		menuItemOld.setCategory(menuItem.getCategory());
		menuItemOld.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuItemOld.setFreeDelivery(menuItem.isFreeDelivery());
		menuItemOld.setName(menuItem.getName());
		menuItemOld.setPrice(menuItem.getPrice());
		menuItemRepository.save(menuItemOld);
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuItemRepository.save(menuItem);
	}

	@Override
	public void deleteMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		menuItemRepository.deleteById(menuItemId);
	}

	

}
