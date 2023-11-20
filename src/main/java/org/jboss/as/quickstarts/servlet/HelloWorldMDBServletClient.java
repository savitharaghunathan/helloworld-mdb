package org.jboss.as.quickstarts.servlet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.Destination;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.List;
import java.util.ArrayList;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;


@ApplicationScoped
@Path("/HelloWorldMDBServletClient")
public class HelloWorldMDBServletClient {

    private static final int MSG_COUNT = 5;

    @Inject
    @Channel("HELLOWORLDMDBQueue")
    Emitter<String> queueEmitter;

    @Inject
    @Channel("HELLOWORLDMDBTopic")
    Emitter<String> topicEmitter;

    @Inject
    Template exampleTemplate;

    @GET
    @Produces("text/html")
    public TemplateInstance doGet(UriInfo uriInfo) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        boolean isUsingTopic = queryParams.containsKey("topic");


        Emitter<String> emitter = isUsingTopic ? topicEmitter : queueEmitter;
        List<String> messages = generateMessages(emitter);

        return exampleTemplate
                .data("destination", isUsingTopic ? "Topic" : "Queue")
                .data("messages", messages)
                .data("useTopic", isUsingTopic);
    }

    private List<String> generateMessages(Emitter<String> emitter) {
        List<String> messages = new ArrayList<>();

        for (int i = 1; i <= MSG_COUNT; i++) {
            String messageText = "This is message " + i;
            messages.add(messageText);
            emitter.send(messageText);
        }

        return messages;
    }
}
