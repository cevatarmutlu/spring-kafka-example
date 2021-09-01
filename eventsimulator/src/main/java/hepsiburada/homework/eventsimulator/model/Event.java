package hepsiburada.homework.eventsimulator.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private String productId;

    private String userId;
    private long timestamp;


    @Override
    public String toString() {
        return "Event{" +
                "productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
