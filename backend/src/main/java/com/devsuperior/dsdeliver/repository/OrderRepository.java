package com.devsuperior.dsdeliver.repository;

import com.devsuperior.dsdeliver.model.Order;
import com.devsuperior.dsdeliver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
