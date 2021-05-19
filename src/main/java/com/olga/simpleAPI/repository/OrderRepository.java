package com.olga.simpleAPI.repository;

import com.olga.simpleAPI.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderById();

    Order findOrderById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update orders\n" +
            "set name = :name,\n" +
            "price = :price\n" +
            "where id = :id",
            nativeQuery = true)
    void updateOrderNameAndPriceById(Long id, String name, int price);

    @Modifying
    @Transactional
    void deleteOrderById(long id);
}
