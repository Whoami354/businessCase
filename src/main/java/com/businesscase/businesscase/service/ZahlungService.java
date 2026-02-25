package com.businesscase.businesscase.service;

import com.businesscase.businesscase.dto.ZahlungRequestDto;
import com.businesscase.businesscase.dto.ZahlungResponseDto;
import com.businesscase.businesscase.model.Zahlung;
import com.businesscase.businesscase.repository.ZahlungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ZahlungService {

    private final ZahlungRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ZahlungResponseDto create(ZahlungRequestDto dto) {
        Zahlung zahlung = mapToEntity(dto);
        return mapToResponse(repository.save(zahlung));
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
