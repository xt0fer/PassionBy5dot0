package com.caraeppes.EduWaiterAppServer.services;

import com.caraeppes.EduWaiterAppServer.models.Menu;
import com.caraeppes.EduWaiterAppServer.repositories.MenuRepository;
import com.caraeppes.EduWaiterAppServer.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private MenuRepository menuRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Menu create(Menu menu){
        return menuRepository.save(menu);
    }

    public Menu findById(Long id){
        return menuRepository.getOne(id);
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Menu update(Menu menu, Long id){
        Menu original = menuRepository.getOne(id);
        original.setName(menu.getName());
        original.setDescription(menu.getDescription());
        original.setRestaurant(menu.getRestaurant());
        original.setMenuItems(menu.getMenuItems());
        return menuRepository.save(original);
    }

    public Menu updateDescription(Menu menu, String description){
        menu.setDescription(description);
        return menuRepository.save(menu);
    }

    public Menu updateRestaurant(Menu menu, Long restaurantId){
        menu.setRestaurant(restaurantRepository.getOne(restaurantId));
        return menuRepository.save(menu);
    }

    public Boolean deleteById (Long id){
        menuRepository.deleteById(id);
        return true;
    }
}
