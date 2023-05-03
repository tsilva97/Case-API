# DeepDive Case API

This project does the following: 
- Exposes an endpoint to post messages to a kafka server (/message)
- Exposes an endpoint to post device locations to a kafka server (/position)
- Exposes an endpoint to "delete" device location in a kafka server (/position)

## Example Requests 


### Post message
POST request on /message with body:
```json
{
  "sender": "Alice",
  "recipient": "Bob",
  "title": "Hello",
  "content": "World"
}
```

### Post device location
POST request on /position with body:
```json
{
  "deviceId": "id123",
  "x": 4.767,
  "y": 5.4,
  "z": -88
}
```

### Delete device location
DELETE request on /position with body:
```json
{
  "deviceId": "id123"
}
```


## Usage 
To use this project boot up the development kafka server with:
```command
docker-compose up -d
```

Create the topics "messages" and "device-locations" with the correct (4) partitions inside docker with:
```command
kafka-topics.sh --bootstrap-server localhost:9092 --topic messages --create --partitions
kafka-topics.sh --bootstrap-server localhost:9092 --topic device-locations --create --partitions
```

Then boot up the project using maven.
```command
mvn spring-boot:run
```

## Possible Improvements

- Pass the topic names and kafka host as env vars
- Add logging
- Add tests

