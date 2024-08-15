package com.travelling.travelling.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.travelling.travelling.service.AccommodationService;
import com.travelling.travelling.utils.dto.AccommodationDTO;
import com.travelling.travelling.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accommodations")
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody AccommodationDTO request) {
        return Response.renderJSON(accommodationService.create(request), "ACCOMMODATION CREATED");
    }

    @GetMapping
    private ResponseEntity<?> getAll(
    ) {
        return Response.renderJSON(accommodationService.getAll(), "SHOW ALL ACCOMMODATIONS");
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return Response.renderJSON(accommodationService.getById(id), "SHOW ACCOMMODATION");
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody AccommodationDTO request) {
        return Response.renderJSON(accommodationService.update(request, id), "ACCOMMODATION UPDATED");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id) {
        return Response.renderJSON(accommodationService.deleteById(id), "ACCOMMODATION DELETED");
    }
}
