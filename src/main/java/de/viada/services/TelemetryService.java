package de.viada.services;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.mqtt.MqttMessage;

@ApplicationScoped
public class TelemetryService {
    
	
	//Sending telemetry everey 5 seconds
	//Ggf von String auf auf JSON umstellen
    @Outgoing("pollution")
    public Multi<String> sendPollutionWithTimer() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(x -> "A Message in here");
    }
    
    
    @Outgoing("pollution")
    public Multi<String> sendGasWithTimer() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(x -> "A Message in here");
    }
    
    
    //Sending telemetry once 
    //Return-Type is of type completionStage to check if the message is send properly
    @Outgoing("pollution")
    public CompletionStage<MqttMessage> sendPollutionCompletionStage(String data) {
        CompletableFuture<MqttMessage> future = new CompletableFuture<>();
        System.out.println("Sending message on topic: hello");
        future.complete(MqttMessage.of("pollution", data,
                    null, true));
        return future;
    }
    
    @Outgoing("gas")
    public CompletionStage<MqttMessage> sendGasCompletionStage(String data) {
        CompletableFuture<MqttMessage> future = new CompletableFuture<>();
        System.out.println("Sending message on topic: hello");
        future.complete(MqttMessage.of("gas", data,
                    null, true));
        return future;
    }
 
// Example on how to handle Completion-Stages in calling method
//    CompletionStage<Void> send = TelemetryService.send();
//    send.whenComplete((unused, throwable) -> {
//            System.out.println("Managed to send data.");
//        })
//        .exceptionally(throwable -> {
//            System.out.println("Failed to send message. Error: " + throwable.getMessage());
//        });

}
