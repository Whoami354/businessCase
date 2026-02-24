package com.businesscase.businesscase.dto;

import com.businesscase.businesscase.model.Status;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class ZahlungRequestDto {

    @NotNull
    private Status status;

    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
    private String zahlungsdatum;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal betrag;
}
