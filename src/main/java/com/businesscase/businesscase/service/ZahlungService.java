package com.businesscase.businesscase.service;

import com.businesscase.businesscase.dto.ZahlungRequestDto;
import com.businesscase.businesscase.dto.ZahlungResponseDto;
import com.businesscase.businesscase.exception.ResourceNotFoundException;
import com.businesscase.businesscase.model.Zahlung;
import com.businesscase.businesscase.repository.ZahlungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZahlungService {

    private final ZahlungRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ZahlungResponseDto create(ZahlungRequestDto dto) {
        Zahlung zahlung = mapToEntity(dto);
        return mapToResponse(repository.save(zahlung));
    }

    public ZahlungResponseDto getById(Long id) {
        var zahlung = repository.findById(id);

        return mapToResponse(zahlung.get());
    }

    public List<ZahlungResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ZahlungResponseDto update(Long id, ZahlungRequestDto dto) {
        var zahlung = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zahlung nicht gefunden"));

        zahlung.setStatus(dto.getStatus());
        zahlung.setZahlungsDatum(LocalDate.parse(dto.getZahlungsdatum(), formatter));
        zahlung.setBetrag(dto.getBetrag());

        return mapToResponse(repository.save(zahlung));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Zahlung mapToEntity(ZahlungRequestDto dto) {
        return Zahlung.builder()
                .status(dto.getStatus())
                .zahlungsDatum(LocalDate.parse(dto.getZahlungsdatum(), formatter))
                .betrag(dto.getBetrag())
                .build();
    }

    private ZahlungResponseDto mapToResponse(Zahlung zahlung) {
        return ZahlungResponseDto.builder()
                .id(zahlung.getId())
                .status(zahlung.getStatus())
                .zahlungsdatum(zahlung.getZahlungsDatum().format(formatter))
                .betrag(zahlung.getBetrag())
                .build();
    }
}
