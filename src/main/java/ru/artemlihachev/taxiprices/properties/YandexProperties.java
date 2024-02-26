package ru.artemlihachev.taxiprices.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "yandex")
@Component
public class YandexProperties {
    private String clid;
    private String apiKey;
}
