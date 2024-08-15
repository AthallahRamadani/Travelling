package com.travelling.travelling.service.impl;

import com.travelling.travelling.model.Accommodation;
import com.travelling.travelling.repository.AccommodationRepository;
import com.travelling.travelling.service.AccommodationService;
import com.travelling.travelling.utils.dto.AccommodationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Override
    public Accommodation create(AccommodationDTO request) {
        accommodationRepository.saveAccommodation(
                request.getName(),
                request.getLocation(),
                request.getCategory(),
                request.getPrice());

        return accommodationRepository.findAllAccommodations()
                .stream()
                .filter(accommodation -> accommodation.getName().equals(request.getName()) &&
                        accommodation.getLocation().equals(request.getLocation()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Accommodation> getAll() {
        return accommodationRepository.findAllAccommodations();
    }

    @Override
    public Accommodation getById(Long id) {
        return accommodationRepository.findByIdAccommodation(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found with id: " + id));
    }

    @Override
    public Accommodation update(AccommodationDTO request, Long id) {
        accommodationRepository.updateAccommodation(
                id,
                request.getName(),
                request.getLocation(),
                request.getCategory(),
                request.getPrice());

        return accommodationRepository.findByIdAccommodation(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found with id: " + id));
    }

    @Override
    public String deleteById(Long id) {
        accommodationRepository.deleteByIdAccommodation(id);
        return "Accommodation with id " + id + " has been deleted.";
    }
}

