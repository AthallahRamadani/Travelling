package com.travelling.travelling.repository;

import com.travelling.travelling.model.OrderAcc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderAccRepository extends JpaRepository<OrderAcc, UUID> {

    @Modifying
    @Query(value = "INSERT INTO order_acc (id, total_price, check_in, check_out, user_id, status) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    @Transactional
    void saveOrderAcc(UUID id, Integer totalPrice, LocalDate checkIn, LocalDate checkOut, Long userId, String status);

    @Query(value = "SELECT * FROM order_acc ORDER BY id", nativeQuery = true)
    List<OrderAcc> findAllOrderAcc();

    @Query(value = "SELECT * FROM order_acc WHERE id = ?1", nativeQuery = true)
    Optional<OrderAcc> findByIdOrderAcc(UUID id);

    @Modifying
    @Query(value = "DELETE FROM order_acc WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteByIdOrderAcc(UUID id);

    @Modifying
    @Query(value = "UPDATE order_acc SET total_price = ?2, check_in = ?3, check_out = ?4, user_id = ?5, status = ?6 WHERE id = ?1", nativeQuery = true)
    @Transactional
    void updateOrderAcc(UUID id, Integer totalPrice, LocalDate checkIn, LocalDate checkOut, Long userId, String status);
}
