## Spring Kafka Example

This project is a pipeline that designed for recommendation system of imaginary e-commerce site. When the user views a product, an 'event' is generated and written to the kafka. The event is read from Kafka and write to PostgreSQL database. The REST API returns the best selling 'maxProdCount' product using events in PostgreSQL for the recommendation system.

## Diagram


## Modules

Module | Working
------ | -------
[eventsimulator](eventsimulator) | Generates an 'event' and write the event to Kafka
[eventconsumer](eventconsumer) | Reads events from Kafka and write to PostgreSQL
[api](api) | Returns the best selling 'maxProdCount' product using PostgreSQL events.
