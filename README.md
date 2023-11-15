# helloworld-mdb

To Run this app in jboss-eap:
* Clone - https://github.com/migtools/playpen/
* Create infra - https://github.com/migtools/playpen/blob/main/ec2/README.md#to-create-the-environments
* Edit jboss-eap role and change the config file to `standalone-full.xml` 
* Run the steps from https://github.com/migtools/playpen/blob/main/ec2/README.md#to-create-jboss-eap-instance
* Install `wget` and `git` on the server
* Run `git clone https://github.com/savitharaghunathan/helloworld-mdb.git` in fedora home
* Download maven - `wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz`
* Configure mvn -  `tar -xvf apache-maven-3.9.4-bin.tar.gz`
* Add it to the path - `export MAVEN_HOME=/home/fedora/apache-maven-3.9.4 && export PATH=$PATH:$MAVEN_HOME/bin `
* cd in helloword app folder - `cd helloworld-mdb/`
* Run `mvn clean package`
* copy the `.war` from target to `/opt/jboss-eap/deployments`
* Access the app - `http://ec2-x-x-x-x.compute-1.amazonaws.com:8080/helloworld-mdb/HelloWorldMDBServletClient`
* Watch the logs to see messages like the following,
```
2023-11-15 18:34:59,044 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-11 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 1
2023-11-15 18:34:59,050 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-12 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 2
2023-11-15 18:34:59,163 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-10 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 3
2023-11-15 18:34:59,173 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-11 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 4
2023-11-15 18:34:59,179 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-12 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 5
2023-11-15 18:34:59,266 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-10 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 1
2023-11-15 18:34:59,274 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-11 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 2
2023-11-15 18:34:59,283 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-12 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 3
2023-11-15 18:34:59,290 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-10 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 4
2023-11-15 18:34:59,294 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldQueueMDB] (Thread-12 (ActiveMQ-client-global-threads)) Received Message from queue: This is message 5
```
* Add messges to the topic using - `http://ec2-x-x-x-x.compute-1.amazonaws.com:8080/helloworld-mdb//HelloWorldMDBServletClient?topic`
```
2023-11-15 18:43:27,540 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-16 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 1
2023-11-15 18:43:27,540 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-17 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 2
2023-11-15 18:43:27,543 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-14 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 4
2023-11-15 18:43:27,544 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-15 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 5
2023-11-15 18:43:27,544 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-13 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 3
2023-11-15 18:43:27,696 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-17 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 1
2023-11-15 18:43:27,696 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-13 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 2
2023-11-15 18:43:27,698 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-15 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 3
2023-11-15 18:43:27,698 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-13 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 5
2023-11-15 18:43:27,699 INFO  [class org.jboss.as.quickstarts.mdb.HelloWorldTopicMDB] (Thread-16 (ActiveMQ-client-global-threads)) Received Message from topic: This is message 4
```
