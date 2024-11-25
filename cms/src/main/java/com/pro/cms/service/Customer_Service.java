package com.pro.cms.service;

import com.pro.cms.dao.CustomerDao;
import com.pro.cms.exception.CustomerNotFoundException;
import com.pro.cms.model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class Customer_Service {

    @Autowired
    private CustomerDao customerDao;


    private int customerIdcount = 1;
    private List<customer> customerList = new CopyOnWriteArrayList<>();

    public customer addcustomer(customer cust){
//        cust.setId(customerIdcount);
//        customerList.add(cust);
//        customerIdcount++;
//        return cust;
        return customerDao.save(cust);
    }

    public List<customer> getCustomerList(){
        return customerDao.findAll();
//        return customerList;
    }

    public customer getcustomer(int custid){
        Optional<customer> optionalCustomer = customerDao.findById(custid);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record Not Available");

//        return customerList.stream().filter(c -> c.getId() == custid).findFirst().get();
       return optionalCustomer.get();
    }

    public customer updatecustomer(int  custid, customer cust){
        cust.setId(custid);

//        customerList.stream().forEach(c ->{
//            if (c.getId() == custid){
//                c.setCustomerFirstName(cust.getCustomerFirstName());
//                c.setCustomerLastName(cust.getCustomerLastName());
//                c.setCustomerEmail(cust.getCustomerEmail());
//            }
//        });
//        return customerList.stream().filter(c -> c.getId() == custid).findFirst().get();
        return customerDao.save(cust);
    }

    public void deletecustomer(int id){
//        customerList.stream().forEach(c -> {
//            if(c.getId() == id){
//                customerList.remove(c);
//            }
//        });
        customerDao.deleteById(id);
    }
}
