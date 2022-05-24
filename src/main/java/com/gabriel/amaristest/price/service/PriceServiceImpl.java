package com.gabriel.amaristest.price.service;

import com.gabriel.amaristest.price.interfaces.PriceService;
import com.gabriel.amaristest.price.model.dto.price.PriceRequest;
import com.gabriel.amaristest.price.model.entity.Price;
import com.gabriel.amaristest.price.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "PriceServiceImpl")
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public Optional<Price> findRateWithMorePriority(PriceRequest priceRequest) {
        return priceRepository.findRateWithMorePriority(priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());
    }
}
