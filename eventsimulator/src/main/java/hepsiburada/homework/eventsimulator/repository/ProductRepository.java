package hepsiburada.homework.eventsimulator.repository;

import hepsiburada.homework.eventsimulator.model.Product;
import hepsiburada.homework.eventsimulator.model.ProductIdQueryResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(value = "SELECT product_id as productId FROM products LIMIT 1 OFFSET :offset",
        nativeQuery = true)
    List<ProductIdQueryResult> getProductId(@Param("offset") int offset);

}
