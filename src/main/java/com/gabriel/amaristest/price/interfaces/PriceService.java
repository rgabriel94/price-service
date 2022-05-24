package com.gabriel.amaristest.price.interfaces;

import com.gabriel.amaristest.price.model.dto.price.PriceRequest;
import com.gabriel.amaristest.price.model.entity.Price;

import java.util.Optional;

public interface PriceService {

    Optional<Price> findRateWithMorePriority(PriceRequest priceRequest);
}
