# helloworld-mdb

To Run this app in quarkus:

* Clone `git clone https://github.com/savitharaghunathan/helloworld-mdb.git`. Checkout the branch `quarkus`
* Run `mvn clean quarkus:dev`
* Access the app - `http://localhost:8080/HelloWorldMDBServletClient`
* Watch the logs to see messages like the following,
```
2023-11-22 16:19:18,023 INFO  [cla.jbo.as.qui.mdb.HelloWorldQueueMDB] (vert.x-eventloop-thread-2) Received Message from queue: This is message 1
2023-11-22 16:19:18,025 INFO  [cla.jbo.as.qui.mdb.HelloWorldQueueMDB] (vert.x-eventloop-thread-2) Received Message from queue: This is message 2
2023-11-22 16:19:18,026 INFO  [cla.jbo.as.qui.mdb.HelloWorldQueueMDB] (vert.x-eventloop-thread-2) Received Message from queue: This is message 3
2023-11-22 16:19:18,027 INFO  [cla.jbo.as.qui.mdb.HelloWorldQueueMDB] (vert.x-eventloop-thread-2) Received Message from queue: This is message 4
2023-11-22 16:19:18,028 INFO  [cla.jbo.as.qui.mdb.HelloWorldQueueMDB] (vert.x-eventloop-thread-2) Received Message from queue: This is message 5

```
* Add messges to the topic using - `http://localhost:8080/HelloWorldMDBServletClient?topic`
```
2023-11-22 16:18:45,290 INFO  [cla.jbo.as.qui.mdb.HelloWorldTopicMDB] (vert.x-eventloop-thread-2) Received Message from Topic: This is message 1
2023-11-22 16:18:45,293 INFO  [cla.jbo.as.qui.mdb.HelloWorldTopicMDB] (vert.x-eventloop-thread-2) Received Message from Topic: This is message 2
2023-11-22 16:18:45,293 INFO  [cla.jbo.as.qui.mdb.HelloWorldTopicMDB] (vert.x-eventloop-thread-2) Received Message from Topic: This is message 3
2023-11-22 16:18:45,294 INFO  [cla.jbo.as.qui.mdb.HelloWorldTopicMDB] (vert.x-eventloop-thread-2) Received Message from Topic: This is message 4
2023-11-22 16:18:45,295 INFO  [cla.jbo.as.qui.mdb.HelloWorldTopicMDB] (vert.x-eventloop-thread-2) Received Message from Topic: This is message 5

```
