package ru.artemlihachev.taxiprices.sheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.artemlihachev.taxiprices.model.Coordinate;
import ru.artemlihachev.taxiprices.properties.CoordinateProperties;
import ru.artemlihachev.taxiprices.service.TaxiService;

@Service
@RequiredArgsConstructor
public class YandexScheduler {
    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());

        taxiService.getPrice(startPoint, endPoint);

    }
}
