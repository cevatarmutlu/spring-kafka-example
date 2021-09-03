package hepsiburada.homework.api.repository;

import hepsiburada.homework.api.model.BestsellerQueryResponse;
import hepsiburada.homework.api.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, String> {

    @Query(value = "" +
            "SELECT product_id AS productId, count(*) AS count " +
            "FROM events e " +
            "GROUP BY product_id " +
            "ORDER BY count DESC " +
            "LIMIT :limit",
            nativeQuery = true)
    List<BestsellerQueryResponse> findBestsellerProducts(@Param("limit") int limit);
}
