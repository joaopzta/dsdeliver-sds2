package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.model.Order;
import com.devsuperior.dsdeliver.model.OrderStatus;
import com.devsuperior.dsdeliver.model.Product;
import com.devsuperior.dsdeliver.repository.OrderRepository;
import com.devsuperior.dsdeliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> products = orderRepository.findOrdersWithProducts();
        return products.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLongitude(),
                orderDTO.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for (ProductDTO productDTO : orderDTO.getProducts()) {
            Product product = productRepository.getOne(productDTO.getId());
            order.getProducts().add(product);
        }
        return new OrderDTO(orderRepository.save(order));
    }

}
