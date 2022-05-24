package com.gabriel.amaristest.price.controller;

import com.gabriel.amaristest.price.interfaces.MapperForTest;
import com.gabriel.amaristest.price.model.dto.error.ErrorResponse;
import com.gabriel.amaristest.price.model.dto.price.PriceRequest;
import com.gabriel.amaristest.price.model.dto.price.PriceResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest implements MapperForTest {
    private final String urlPrices = "/api/prices";
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    private PriceRequest priceRequest;
    private PriceResponse priceResponseExpected;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        priceRequest = PriceRequest.builder()
                .productId(35455L)
                .brandId(1L)
                .build();
        priceResponseExpected = PriceResponse.builder()
                .brandId(1L)
                .productId(35455L)
                .build();
    }

    @AfterEach
    void after() {
        priceRequest = null;
        priceResponseExpected = null;
    }

    @Test
    void findRateWithMorePriorityValidCaseOneTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-10.00.00"));
        priceResponseExpected.setId(1L);
        priceResponseExpected.setStartDate(dateFormatter.parse("2020-06-14-00.00.00"));
        priceResponseExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceResponseExpected.setPriceList(1);
        priceResponseExpected.setCurrentPrice(35.50);
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapperToJson(priceResponseExpected)));
    }

    @Test
    void findRateWithMorePriorityValidCaseTwoTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-16.00.00"));
        priceResponseExpected.setId(2L);
        priceResponseExpected.setStartDate(dateFormatter.parse("2020-06-14-15.00.00"));
        priceResponseExpected.setEndDate(dateFormatter.parse("2020-06-14-18.30.00"));
        priceResponseExpected.setPriceList(2);
        priceResponseExpected.setCurrentPrice(25.45);
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());

        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapperToJson(priceResponseExpected)));
    }

    @Test
    void findRateWithMorePriorityValidCaseThreeTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-21.00.00"));
        priceResponseExpected.setId(1L);
        priceResponseExpected.setStartDate(dateFormatter.parse("2020-06-14-00.00.00"));
        priceResponseExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceResponseExpected.setPriceList(1);
        priceResponseExpected.setCurrentPrice(35.50);
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapperToJson(priceResponseExpected)));
    }

    @Test
    void findRateWithMorePriorityValidCaseFourTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-15-10.00.00"));
        priceResponseExpected.setId(3L);
        priceResponseExpected.setStartDate(dateFormatter.parse("2020-06-15-00.00.00"));
        priceResponseExpected.setEndDate(dateFormatter.parse("2020-06-15-11.00.00"));
        priceResponseExpected.setPriceList(3);
        priceResponseExpected.setCurrentPrice(30.50);
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapperToJson(priceResponseExpected)));
    }

    @Test
    void findRateWithMorePriorityValidCaseFiveTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-16-21.00.00"));
        priceResponseExpected.setId(4L);
        priceResponseExpected.setStartDate(dateFormatter.parse("2020-06-15-16.00.00"));
        priceResponseExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceResponseExpected.setPriceList(4);
        priceResponseExpected.setCurrentPrice(38.95);
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapperToJson(priceResponseExpected)));
    }

    @Test
    void findRateWithMorePriorityNotParametersUrlTest() throws Exception {
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate");
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    void findRateWithMorePriorityNotFoundTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2000-06-16-21.00.00"));
        ErrorResponse errorResponse = ErrorResponse.builder().message("Price not found.").build();
        StringBuilder sb = new StringBuilder(urlPrices);
        sb.append("/rate?");
        sb.append("application_date=").append(dateFormatter.format(priceRequest.getApplicationDate()));
        sb.append("&product_id=").append(priceRequest.getProductId());
        sb.append("&brand_id=").append(priceRequest.getBrandId());
        this.mockMvc.perform(MockMvcRequestBuilders.get(sb.toString()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().json(mapperToJson(errorResponse)));
    }
}
