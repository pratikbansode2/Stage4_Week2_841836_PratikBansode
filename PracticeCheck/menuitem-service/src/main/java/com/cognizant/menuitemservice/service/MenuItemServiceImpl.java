package com.cognizant.menuitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.dao.MenuItemDao;
import com.cognizant.menuitemservice.dao.MenuItemDaoCollectionImpl;
import com.cognizant.menuitemservice.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	MenuItemDaoCollectionImpl menuItemDaoCollectionImpl;
	
	public MenuItem getMenuItem(long id)
	{
		return menuItemDaoCollectionImpl.getMenuItem(id);
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		return menuItemDaoCollectionImpl.getMenuItemListCustomer();
	}

	public void modifyMenuItem(long menuItemId,MenuItem menuItem) {
		menuItemDaoCollectionImpl.modifyMenuItem(menuItemId,menuItem);
		
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuItemDaoCollectionImpl.addMenuItem(menuItem);
	}

	@Override
	public void deleteMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		menuItemDaoCollectionImpl.deleteMenuItem(menuItemId);
	}

}
