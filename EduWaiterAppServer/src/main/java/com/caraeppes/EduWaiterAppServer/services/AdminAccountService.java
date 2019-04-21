package com.caraeppes.EduWaiterAppServer.services;

import com.caraeppes.EduWaiterAppServer.models.AdminAccount;
import com.caraeppes.EduWaiterAppServer.repositories.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAccountService {

    private AdminAccountRepository adminAccountRepository;
    private RestaurantService restaurantService;

    @Autowired
    public AdminAccountService(AdminAccountRepository adminAccountRepository,
                               RestaurantService restaurantService) {
        this.adminAccountRepository = adminAccountRepository;
        this.restaurantService = restaurantService;
    }

    public AdminAccount create(AdminAccount adminAccount){
        return adminAccountRepository.save(adminAccount);
    }

    public AdminAccount findById(Long id){
        return adminAccountRepository.getOne(id);
    }

    public List<AdminAccount> findAll(){
        return adminAccountRepository.findAll();
    }

    public AdminAccount findByUsername(String username){
        return adminAccountRepository.findAdminAccountByUsername(username);
    }

    public AdminAccount update(AdminAccount adminAccount, Long id){
        AdminAccount original = adminAccountRepository.getOne(id);
        original.setFirstName(adminAccount.getFirstName());
        original.setLastName(adminAccount.getLastName());
        original.setRestaurant(adminAccount.getRestaurant());
        return adminAccountRepository.save(original);
    }

    public AdminAccount updateRestaurant(Long id, Long restaurantId){
        AdminAccount original = adminAccountRepository.getOne(id);
        original.setRestaurant(restaurantService.findById(restaurantId));
        return adminAccountRepository.save(original);
    }

    public Boolean deleteById(Long id){
        adminAccountRepository.deleteById(id);
        return true;
    }


}
