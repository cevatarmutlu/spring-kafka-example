package hepsiburada.homework.eventsimulator.service;

import hepsiburada.homework.eventsimulator.model.ProductIdQueryResult;
import hepsiburada.homework.eventsimulator.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Long getRowCount() {
        return productRepository.count();
    }

    public List<ProductIdQueryResult> getProductId(int rowCount) {
        int offset = rowCount - 1;
        return productRepository.getProductId(offset);
    }

}
