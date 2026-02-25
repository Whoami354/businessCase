package com.businesscase.businesscase.controller;

import com.businesscase.businesscase.dto.ZahlungRequestDto;
import com.businesscase.businesscase.dto.ZahlungResponseDto;
import com.businesscase.businesscase.service.ZahlungService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("zahlungen")
@RequiredArgsConstructor
public class ZahlungController {

    private final ZahlungService service;

    @PostMapping("/zahlungenErstellen")
    public ResponseEntity<ZahlungResponseDto> create(@Valid @RequestBody ZahlungRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ZahlungResponseDto> getById(@PathVariable  Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ZahlungResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZahlungResponseDto> update(@PathVariable Long id,
                                                     @Valid @RequestBody ZahlungRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
