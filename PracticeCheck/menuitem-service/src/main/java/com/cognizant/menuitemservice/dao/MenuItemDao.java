package com.cognizant.menuitemservice.dao;


import java.util.List;

import com.cognizant.menuitemservice.model.MenuItem;

public interface MenuItemDao {

	public MenuItem getMenuItem(long menuItemId);

	public List<MenuItem> getMenuItemListCustomer();
	
	public void modifyMenuItem(long menuItemId,MenuItem menuItem);
	
	public void addMenuItem(MenuItem menuItem);
	
	public void deleteMenuItem(long menuItemId);

}
