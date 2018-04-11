package com.novawind.mourn.repository;

import com.novawind.mourn.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jeremy Xiong<br>
 * 2018-04-03 17:25
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
