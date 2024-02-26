package ru.artemlihachev.taxiprices;

import org.springframework.data.repository.CrudRepository;
import ru.artemlihachev.taxiprices.model.MomentPrice;

import java.util.List;

public interface PriceRepository extends CrudRepository<MomentPrice, Long> {
    List<MomentPrice> findAll();
}
