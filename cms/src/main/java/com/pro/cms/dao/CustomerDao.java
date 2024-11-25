package com.pro.cms.dao;

import com.pro.cms.model.customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository<customer, Integer> {

    @Override
    List<customer> findAll();
}
