package com.gabriel.amaristest.price.model.dto.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceResponse {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "brand_id")
    private Long brandId;

    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    @JsonProperty(value = "start_date")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    @JsonProperty(value = "end_date")
    private Date endDate;

    @JsonProperty(value = "price_list")
    private int priceList;

    @JsonProperty(value = "product_id")
    private Long productId;

    @JsonProperty(value = "price")
    private double currentPrice;
}
