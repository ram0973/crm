package ru.aretinsky.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aretinsky.crm.model.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
