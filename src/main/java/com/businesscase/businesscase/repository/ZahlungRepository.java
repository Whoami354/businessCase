package com.businesscase.businesscase.repository;

import com.businesscase.businesscase.model.Zahlung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahlungRepository  extends JpaRepository<Zahlung, Long> {

}
