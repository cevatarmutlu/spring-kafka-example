package hepsiburada.homework.eventsimulator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "category_id")
    private String categoryId;

}
