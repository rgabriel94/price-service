package com.gabriel.amaristest.price.model.dto.price;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PriceRequest {

    @JsonProperty(value = "application_date")
    private Date applicationDate;

    @JsonProperty(value = "product_id")
    private Long productId;

    @JsonProperty(value = "brand_id")
    private Long brandId;
}
