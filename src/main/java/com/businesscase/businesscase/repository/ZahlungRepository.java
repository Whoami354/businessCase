package com.businesscase.businesscase.repository;

import com.businesscase.businesscase.model.Zahlung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZahlungRepository  extends JpaRepository<Zahlung, Long> {
    Optional<Zahlung> findById(Long id);
}
