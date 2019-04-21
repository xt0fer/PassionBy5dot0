package com.caraeppes.EduWaiterAppServer.services;

import com.caraeppes.EduWaiterAppServer.models.EmployeeAccount;
import com.caraeppes.EduWaiterAppServer.repositories.EmployeeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAccountService {

    private EmployeeAccountRepository employeeAccountRepository;

    @Autowired
    public EmployeeAccountService(EmployeeAccountRepository employeeAccountRepository) {
        this.employeeAccountRepository = employeeAccountRepository;
    }

    public EmployeeAccount create(EmployeeAccount employeeAccount){
        return employeeAccountRepository.save(employeeAccount);
    }

    public EmployeeAccount findById(Long id){
        return employeeAccountRepository.getOne(id);
    }

    public List<EmployeeAccount> findAll(){
        return employeeAccountRepository.findAll();
    }

    public EmployeeAccount findByUsername(String username){
        return employeeAccountRepository.findByUsername(username);
    }

    public EmployeeAccount update(EmployeeAccount employeeAccount, Long id){
         EmployeeAccount original = employeeAccountRepository.getOne(id);
         original.setFirstName(employeeAccount.getFirstName());
         original.setLastName(employeeAccount.getLastName());
         original.setRestaurant(employeeAccount.getRestaurant());
         return employeeAccountRepository.save(original);
    }

    public Boolean deleteById(Long id){
        employeeAccountRepository.deleteById(id);
        return true;
    }
}
