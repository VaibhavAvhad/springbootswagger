package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer>saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>>getDataById(@PathVariable int custId){
        return  ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }


    @GetMapping("/getalldata")
    public  ResponseEntity<List<Customer>>getAllData(){
        return  ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public  ResponseEntity<Customer>updateData(@PathVariable int custId,@RequestBody Customer customer ) throws RecordNotFoundException {
      Customer customer1= customerServiceImpl.getDataById(custId).orElseThrow(()-> new RecordNotFoundException("Customer Record Does Not Exist"));

      customer1.setCustName(customer.getCustName());
      customer1.setCustAddress(customer.getCustAddress());
      customer1.setCustContactNo(customer.getCustContactNo());
      customer1.setCustDob(customer.getCustDob());

      return ResponseEntity.ok(customerServiceImpl.updateData(customer1));

    }

    @DeleteMapping("/deletedata/{custId}")
    public ResponseEntity<String>deleteData(@PathVariable int custId){
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Data deleted Successfully");


    }
}
