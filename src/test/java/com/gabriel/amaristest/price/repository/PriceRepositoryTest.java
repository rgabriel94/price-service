package com.gabriel.amaristest.price.repository;

import com.gabriel.amaristest.price.model.dto.price.PriceRequest;
import com.gabriel.amaristest.price.model.entity.Price;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.SimpleDateFormat;
import java.util.Optional;

@DataJpaTest
class PriceRepositoryTest {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    @Autowired
    private PriceRepository priceRepository;

    private PriceRequest priceRequest;
    private Price priceExpected;

    @BeforeEach
    void before() {
        priceRequest = PriceRequest.builder()
                .productId(35455L)
                .brandId(1L)
                .build();
        priceExpected = Price.builder()
                .brandId(1L)
                .productId(35455L)
                .currency("EUR")
                .build();
    }

    @AfterEach
    void after() {
        priceRequest = null;
        priceExpected = null;
    }

    @Test
    void findAllRatesValidCaseOneTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-10.00.00"));
        priceExpected.setId(1L);
        priceExpected.setStartDate(dateFormatter.parse("2020-06-14-00.00.00"));
        priceExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceExpected.setPriceList(1);
        priceExpected.setPriority(0);
        priceExpected.setCurrentPrice(35.50);
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());

        Assertions.assertTrue(priceOptional.isPresent());
        Price price = priceOptional.get();
        Assertions.assertEquals(priceExpected.getId(), price.getId());
        Assertions.assertEquals(priceExpected.getBrandId(), price.getBrandId());
        Assertions.assertEquals(priceExpected.getStartDate(), price.getStartDate());
        Assertions.assertEquals(priceExpected.getEndDate(), price.getEndDate());
        Assertions.assertEquals(priceExpected.getPriceList(), price.getPriceList());
        Assertions.assertEquals(priceExpected.getProductId(), price.getProductId());
        Assertions.assertEquals(priceExpected.getPriority(), price.getPriority());
        Assertions.assertEquals(priceExpected.getCurrentPrice(), price.getCurrentPrice());
        Assertions.assertEquals(priceExpected.getCurrency(), price.getCurrency());
    }

    @Test
    void findAllRatesValidCaseTwoTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-16.00.00"));
        priceExpected.setId(2L);
        priceExpected.setStartDate(dateFormatter.parse("2020-06-14-15.00.00"));
        priceExpected.setEndDate(dateFormatter.parse("2020-06-14-18.30.00"));
        priceExpected.setPriceList(2);
        priceExpected.setPriority(1);
        priceExpected.setCurrentPrice(25.45);
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());

        Assertions.assertTrue(priceOptional.isPresent());
        Price price = priceOptional.get();
        Assertions.assertEquals(priceExpected.getId(), price.getId());
        Assertions.assertEquals(priceExpected.getBrandId(), price.getBrandId());
        Assertions.assertEquals(priceExpected.getStartDate(), price.getStartDate());
        Assertions.assertEquals(priceExpected.getEndDate(), price.getEndDate());
        Assertions.assertEquals(priceExpected.getPriceList(), price.getPriceList());
        Assertions.assertEquals(priceExpected.getProductId(), price.getProductId());
        Assertions.assertEquals(priceExpected.getPriority(), price.getPriority());
        Assertions.assertEquals(priceExpected.getCurrentPrice(), price.getCurrentPrice());
        Assertions.assertEquals(priceExpected.getCurrency(), price.getCurrency());
    }

    @Test
    void findAllRatesValidCaseThreeTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-14-21.00.00"));
        priceExpected.setId(1L);
        priceExpected.setStartDate(dateFormatter.parse("2020-06-14-00.00.00"));
        priceExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceExpected.setPriceList(1);
        priceExpected.setPriority(0);
        priceExpected.setCurrentPrice(35.50);
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());

        Assertions.assertTrue(priceOptional.isPresent());
        Price price = priceOptional.get();
        Assertions.assertEquals(priceExpected.getId(), price.getId());
        Assertions.assertEquals(priceExpected.getBrandId(), price.getBrandId());
        Assertions.assertEquals(priceExpected.getStartDate(), price.getStartDate());
        Assertions.assertEquals(priceExpected.getEndDate(), price.getEndDate());
        Assertions.assertEquals(priceExpected.getPriceList(), price.getPriceList());
        Assertions.assertEquals(priceExpected.getProductId(), price.getProductId());
        Assertions.assertEquals(priceExpected.getPriority(), price.getPriority());
        Assertions.assertEquals(priceExpected.getCurrentPrice(), price.getCurrentPrice());
        Assertions.assertEquals(priceExpected.getCurrency(), price.getCurrency());
    }

    @Test
    void findAllRatesValidCaseFourTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-15-10.00.00"));
        priceExpected.setId(3L);
        priceExpected.setStartDate(dateFormatter.parse("2020-06-15-00.00.00"));
        priceExpected.setEndDate(dateFormatter.parse("2020-06-15-11.00.00"));
        priceExpected.setPriceList(3);
        priceExpected.setPriority(1);
        priceExpected.setCurrentPrice(30.50);
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());

        Assertions.assertTrue(priceOptional.isPresent());
        Price price = priceOptional.get();
        Assertions.assertEquals(priceExpected.getId(), price.getId());
        Assertions.assertEquals(priceExpected.getBrandId(), price.getBrandId());
        Assertions.assertEquals(priceExpected.getStartDate(), price.getStartDate());
        Assertions.assertEquals(priceExpected.getEndDate(), price.getEndDate());
        Assertions.assertEquals(priceExpected.getPriceList(), price.getPriceList());
        Assertions.assertEquals(priceExpected.getProductId(), price.getProductId());
        Assertions.assertEquals(priceExpected.getPriority(), price.getPriority());
        Assertions.assertEquals(priceExpected.getCurrentPrice(), price.getCurrentPrice());
        Assertions.assertEquals(priceExpected.getCurrency(), price.getCurrency());
    }

    @Test
    void findAllRatesValidCaseFiveTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("2020-06-16-21.00.00"));
        priceExpected.setId(4L);
        priceExpected.setStartDate(dateFormatter.parse("2020-06-15-16.00.00"));
        priceExpected.setEndDate(dateFormatter.parse("2020-12-31-23.59.59"));
        priceExpected.setPriceList(4);
        priceExpected.setPriority(1);
        priceExpected.setCurrentPrice(38.95);
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());

        Assertions.assertTrue(priceOptional.isPresent());
        Price price = priceOptional.get();
        Assertions.assertEquals(priceExpected.getId(), price.getId());
        Assertions.assertEquals(priceExpected.getBrandId(), price.getBrandId());
        Assertions.assertEquals(priceExpected.getStartDate(), price.getStartDate());
        Assertions.assertEquals(priceExpected.getEndDate(), price.getEndDate());
        Assertions.assertEquals(priceExpected.getPriceList(), price.getPriceList());
        Assertions.assertEquals(priceExpected.getProductId(), price.getProductId());
        Assertions.assertEquals(priceExpected.getPriority(), price.getPriority());
        Assertions.assertEquals(priceExpected.getCurrentPrice(), price.getCurrentPrice());
        Assertions.assertEquals(priceExpected.getCurrency(), price.getCurrency());
    }

    @Test
    void findRateWithMorePriorityNotFoundTest() throws Exception {
        priceRequest.setApplicationDate(dateFormatter.parse("1900-06-16-21.00.00"));
        Optional<Price> priceOptional = priceRepository.findRateWithMorePriority(
                priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());
        Assertions.assertTrue(priceOptional.isEmpty());
    }
}
