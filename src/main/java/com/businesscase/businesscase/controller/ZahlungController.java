package com.businesscase.businesscase.controller;

import com.businesscase.businesscase.dto.ZahlungRequestDto;
import com.businesscase.businesscase.dto.ZahlungResponseDto;
import com.businesscase.businesscase.service.ZahlungService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("zahlungen")
@RequiredArgsConstructor
public class ZahlungController {

    private final ZahlungService service;

    @PostMapping("zahlungenErstellen")
    public ResponseEntity<ZahlungResponseDto> create(@Valid @RequestBody ZahlungRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
}
