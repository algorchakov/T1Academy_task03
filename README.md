# Task #3 T1Academy (Kafka)
## Overview
Training project to implement a monitoring system using Spring Kafka

You can run MerticsProduser module to start embedded on port 8080 and MetricsConsumer on port 8079
The test method will collect free memory data every 30 seconds. 
Using the post method at localhost:8080/metrics/, MetricsProducer will send this data to MetricsConsumer using Kafka.
MetricsConsumer will save them to Postgres DB.
