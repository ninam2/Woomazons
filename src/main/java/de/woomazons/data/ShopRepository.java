package de.woomazons.data;


import de.woomazons.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
