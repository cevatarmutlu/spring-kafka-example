package hepsiburada.homework.eventconsumer.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
public class Event {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public void setTimestamp(long timestamp) {
        this.timestamp = new Timestamp(timestamp);
    }

}
