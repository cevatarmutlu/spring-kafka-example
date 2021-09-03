package hepsiburada.homework.api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"productId", "count"}) // For response order
public interface BestsellerQueryResponse {

    String getProductId();

    int getCount();
}
