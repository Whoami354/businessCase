package com.businesscase.businesscase;

import com.businesscase.businesscase.controller.ZahlungController;
import com.businesscase.businesscase.dto.ZahlungResponseDto;
import com.businesscase.businesscase.exception.ResourceNotFoundException;
import com.businesscase.businesscase.model.Status;
import com.businesscase.businesscase.service.ZahlungService;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ZahlungController.class)
class ZahlungControllerTest {

}
