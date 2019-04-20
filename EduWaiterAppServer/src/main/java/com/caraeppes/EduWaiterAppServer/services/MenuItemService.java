package com.caraeppes.EduWaiterAppServer.services;

import com.caraeppes.EduWaiterAppServer.models.Menu;
import com.caraeppes.EduWaiterAppServer.models.MenuItem;
import com.caraeppes.EduWaiterAppServer.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem create(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.getOne(id);
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public MenuItem update(MenuItem menuItem, Long id) {
        MenuItem original = menuItemRepository.getOne(id);
        original.setName(menuItem.getName());
        original.setDescription(menuItem.getDescription());
        original.setMenus(menuItem.getMenus());
        original.setIngredients(menuItem.getIngredients());
        original.setPrice(menuItem.getPrice());
        return menuItemRepository.save(original);
    }

    public Boolean deleteById(Long id) {
        menuItemRepository.deleteById(id);
        return true;
    }
}
