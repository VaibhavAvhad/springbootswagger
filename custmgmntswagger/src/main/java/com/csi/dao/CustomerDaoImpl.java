package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {
    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer saveData(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public Optional<Customer> getDataById(int custId){
        return customerRepoImpl.findById(custId);
    }

    public List<Customer>getAllData(){
        return  customerRepoImpl.findAll();

    }

    public Customer updateData(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public void deleteDataById(int custId){
        customerRepoImpl.deleteById(custId);

    }

}
