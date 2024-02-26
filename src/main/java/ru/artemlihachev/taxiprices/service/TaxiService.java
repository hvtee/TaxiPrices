package ru.artemlihachev.taxiprices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.artemlihachev.taxiprices.PriceRepository;
import ru.artemlihachev.taxiprices.apiclient.TaxiApiClient;
import ru.artemlihachev.taxiprices.model.Coordinate;
import ru.artemlihachev.taxiprices.model.MomentPrice;
import ru.artemlihachev.taxiprices.model.Price;
import ru.artemlihachev.taxiprices.properties.YandexProperties;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxiService {
    private final YandexProperties yandexProperties;
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;


    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.toString() + "~" + endPoint.toString();
        String clid = yandexProperties.getClid();
        String apiKey = yandexProperties.getApiKey();

        Price currentPrice = taxiApiClient.getPrice(clid, apiKey, rll);

        if (currentPrice.getOptions().isEmpty()) {
            throw new RuntimeException("Options are empty");
        }

        double price = currentPrice.getOptions().get(0).getPrice();
        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Europe/Minsk")),
                price
        );
        priceRepository.save(momentPrice);
    }

    public List<MomentPrice> getAllPrices() {
        return priceRepository.findAll();
    }
}
