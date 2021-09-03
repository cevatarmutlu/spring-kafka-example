package hepsiburada.homework.eventsimulator.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Event {

    private String productId;
    private String userId;
    private long timestamp;

}
