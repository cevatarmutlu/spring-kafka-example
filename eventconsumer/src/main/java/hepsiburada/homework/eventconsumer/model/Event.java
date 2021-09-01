package hepsiburada.homework.eventconsumer.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

// Object Serilize ile Event nesnesi yazabilirim kafkaya sanırım.

@Entity
@Table(name = "events")
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
