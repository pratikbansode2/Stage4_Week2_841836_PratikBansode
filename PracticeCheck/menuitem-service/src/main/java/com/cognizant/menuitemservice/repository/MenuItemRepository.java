package com.cognizant.menuitemservice.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitemservice.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepositoryImplementation<MenuItem, Long> {

}
