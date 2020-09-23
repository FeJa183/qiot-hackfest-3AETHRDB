package de.viada.services;

import io.smallrye.reactive.messaging.mqtt.MqttMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class DummyService {

//    @Incoming("gas")
    public CompletionStage<Void> consume(MqttMessage<byte[]> message) {
        String payload = new String(message.getPayload());
        System.out.println("received: " + payload + " from topic: " + message.getTopic());

        return message.ack();
    }
}
