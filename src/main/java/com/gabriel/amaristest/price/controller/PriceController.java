package com.gabriel.amaristest.price.controller;

import com.gabriel.amaristest.price.exception.ResponseException;
import com.gabriel.amaristest.price.interfaces.PriceService;
import com.gabriel.amaristest.price.model.dto.price.PriceRequest;
import com.gabriel.amaristest.price.model.dto.price.PriceResponse;
import com.gabriel.amaristest.price.model.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "api/prices")
public class PriceController extends BaseController {

    @Autowired
    @Qualifier(value = "PriceServiceImpl")
    PriceService priceService;

    @GetMapping(value = "/rate")
    @ResponseStatus(HttpStatus.OK)
    public PriceResponse findRateWithMorePriority(
            @RequestParam(value = "application_date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date applicationDate,
            @RequestParam(value = "product_id") Long productId,
            @RequestParam(value = "brand_id") Long brandId) {
        PriceRequest priceRequest = buildPriceRequest(applicationDate, productId, brandId);
        Price price = priceService.findRateWithMorePriority(priceRequest).orElseThrow(() ->
                new ResponseException(HttpStatus.NOT_FOUND, "Price not found."));
        return mapper.convert(price, PriceResponse.class);
    }

    private PriceRequest buildPriceRequest(Date applicationDate, Long productId, Long brandId) {
        return PriceRequest.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId).build();
    }
}
