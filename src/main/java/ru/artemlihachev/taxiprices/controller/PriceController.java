package ru.artemlihachev.taxiprices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemlihachev.taxiprices.model.MomentPrice;
import ru.artemlihachev.taxiprices.service.TaxiService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PriceController {
    private final TaxiService taxiService;

    @GetMapping("/prices")
    public List<MomentPrice> getAllPrices() {
        return taxiService.getAllPrices();
    }
}
