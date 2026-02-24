package com.businesscase.businesscase.dto;

import com.businesscase.businesscase.model.Status;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ZahlungResponseDto {
    private Long id;
    private Status status;
    private String zahlungsdatum;
    private BigDecimal betrag;
}
