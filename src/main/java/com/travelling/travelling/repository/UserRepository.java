package com.travelling.travelling.repository;

import com.travelling.travelling.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Modifying
    @Query(value = "INSERT INTO users (username, email, password, role) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    @Transactional
    void saveUser(String username, String email, String password, String role);

    @Query(
            value = "SELECT * FROM Users ORDER BY id \n-- #pageable\n",
            countQuery = "SELECT count(*) FROM Users",
            nativeQuery = true)
    Page<UserEntity> findAllUser(Pageable pageable);

    @Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
    Optional<UserEntity> findByIdUser(Long id);

    @Modifying
    @Query(value = "DELETE FROM users WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteByIdUser(Long id);

    @Modifying
    @Query(value = "UPDATE users SET username = ?2, email = ?3, password = ?4 WHERE id = ?1", nativeQuery = true)
    @Transactional
    void updateUser(Long id, String username, String email, String password);

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM users u WHERE username = ?1", nativeQuery = true)
    boolean existsByUsername(String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM users u WHERE email = ?1", nativeQuery = true)
    boolean existsByEmail(String email);
}
