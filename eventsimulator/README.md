## Event Simulator

Generates an event and write to Kafka.

An event is a combination that `product_id`, `user_id`, `timestamp`.

The `product_id` is generated from the `products` table in PostgreSQL. A random row number is generated from the row number of the `products` table, and this row number takes the value of `product_id`.

The `user_id` is generated from a value you specify.

The `timestamp` is the event created date.


## Diagram