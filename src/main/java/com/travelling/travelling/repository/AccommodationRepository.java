package com.travelling.travelling.repository;

import com.travelling.travelling.model.Accommodation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Modifying
    @Query(value = "INSERT INTO accommodations (name, location, category, price) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    @Transactional
    void saveAccommodation(String name, String location, String category, Integer price);

    @Query(value = "SELECT * FROM accommodations ORDER BY id", nativeQuery = true)
    List<Accommodation> findAllAccommodations();

    @Query(value = "SELECT * FROM accommodations WHERE id = ?1", nativeQuery = true)
    Optional<Accommodation> findByIdAccommodation(Long id);

    @Modifying
    @Query(value = "DELETE FROM accommodations WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteByIdAccommodation(Long id);

    @Modifying
    @Query(value = "UPDATE accommodations SET name = ?2, location = ?3, category = ?4, price = ?5 WHERE id = ?1", nativeQuery = true)
    @Transactional
    void updateAccommodation(Long id, String name, String location, String category, Integer price);
}

