package com.codegym.thimodul4.repositories;

import com.codegym.thimodul4.dto.OrderDTO;
import com.codegym.thimodul4.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT new com.codegym.thimodul4.dto.OrderDTO(o.id, o.orderCode, p.name, p.price, pt.name, o.purchaseDate, o.quantity, (p.price * o.quantity)) " +
            "FROM orders o JOIN o.product p on p.id = o.product_id JOIN p.product_type pt on p.product_type_id = pt.id",
            nativeQuery = true)
    List<OrderDTO> findAllOrderDTOs();

}
