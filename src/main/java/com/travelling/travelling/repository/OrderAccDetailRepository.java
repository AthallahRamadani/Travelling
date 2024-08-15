package com.travelling.travelling.repository;

import com.travelling.travelling.model.OrderAccDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderAccDetailRepository extends JpaRepository<OrderAccDetail, Long> {

    @Modifying
    @Query(value = "INSERT INTO order_acc_detail (id, price, quantity, category_room, order_acc_id, accommodation_id) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    @Transactional
    void saveOrderAccDetail(Long id, Integer price, Integer quantity, String categoryRoom, UUID orderAccId, Long accommodationId);

    @Query(value = "SELECT * FROM order_acc_detail ORDER BY id", nativeQuery = true)
    List<OrderAccDetail> findAllOrderAccDetails();

    @Query(value = "SELECT * FROM order_acc_detail WHERE id = ?1", nativeQuery = true)
    Optional<OrderAccDetail> findByIdOrderAccDetail(Long id);

    @Modifying
    @Query(value = "DELETE FROM order_acc_detail WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteByIdOrderAccDetail(Long id);

    @Modifying
    @Query(value = "UPDATE order_acc_detail SET price = ?2, quantity = ?3, category_room = ?4, order_acc_id = ?5, accommodation_id = ?6 WHERE id = ?1", nativeQuery = true)
    @Transactional
    void updateOrderAccDetail(Long id, Integer price, Integer quantity, String categoryRoom, UUID orderAccId, Long accommodationId);
}

