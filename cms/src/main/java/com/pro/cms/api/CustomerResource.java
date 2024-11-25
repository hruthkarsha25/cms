package com.pro.cms.api;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.cms.model.customer;
import com.pro.cms.service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

    @Autowired
    private Customer_Service customerService;

    @PostMapping
    public customer addcustomer(@RequestBody customer cust){
        return customerService.addcustomer(cust);
    }

    @GetMapping
    public List<customer> getCustomers(){
        return customerService.getCustomerList();
    }

    @GetMapping(value = "/{customerId}")
    public customer getCustomer(@PathVariable("customerId") int custid){
        return customerService.getcustomer(custid);
    }

    @PutMapping(value = "/{customerId}")
    public customer updatecustomer(@PathVariable("customerId") int custid, @RequestBody customer cust){
        return customerService.updatecustomer(custid, cust);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deletecustomer(@PathVariable("customerId") int custid){
        customerService.deletecustomer(custid);
    }
}
