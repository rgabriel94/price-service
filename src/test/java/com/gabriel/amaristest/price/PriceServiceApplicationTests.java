package com.gabriel.amaristest.price;

import com.gabriel.amaristest.price.interfaces.PriceService;
import com.gabriel.amaristest.price.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceServiceApplicationTests {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private PriceService priceService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(modelMapper);
		Assertions.assertNotNull(priceRepository);
		Assertions.assertNotNull(priceService);
	}
}
