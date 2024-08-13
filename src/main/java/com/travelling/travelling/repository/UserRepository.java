package com.travelling.travelling.repository;

import com.travelling.travelling.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserEntity> findAllUser();

    @Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
    Optional<UserEntity> findByIdUser(Long id);

    @Modifying
    @Query(value = "DELETE FROM users WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteByIdUser(Long id);

    @Modifying
    @Query(value = "INSERT INTO users (username, email, password, role, profile_picture) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    @Transactional
    void saveUser(String username, String email, String password, String role, String profilePicture);

    @Modifying
    @Query(value = "UPDATE users SET username = ?2, email = ?3, password = ?4, role = ?5, profile_picture = ?6 WHERE id = ?1", nativeQuery = true)
    @Transactional
    void updateUser(Long id, String username, String email, String password, String role, String profilePicture);

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM users u WHERE username = ?1", nativeQuery = true)
    boolean existsByUsername(String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM users u WHERE email = ?1", nativeQuery = true)
    boolean existsByEmail(String email);
}
