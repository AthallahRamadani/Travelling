package com.travelling.travelling.service;

import com.travelling.travelling.model.Accommodation;
import com.travelling.travelling.utils.dto.AccommodationDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccommodationService {
    Accommodation create(AccommodationDTO request);
    List<Accommodation> getAll();
    Accommodation getById(Long id);
    Accommodation update(AccommodationDTO request, Long id);
    String deleteById(Long id);
}