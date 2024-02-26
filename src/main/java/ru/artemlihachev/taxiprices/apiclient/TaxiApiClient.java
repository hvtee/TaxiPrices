package ru.artemlihachev.taxiprices.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.artemlihachev.taxiprices.model.Price;

@FeignClient(name = "yandexclient", url = "${yandex.url}")
@Component
public interface TaxiApiClient {
    @GetMapping
    Price getPrice(@RequestParam String clid, @RequestParam String apiKey, @RequestParam String rll);
}
