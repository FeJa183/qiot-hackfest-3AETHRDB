package de.viada.services;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.viada.dtos.GasTelementry;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.mqtt.MqttMessage;

@ApplicationScoped
public class TelemetryService {

    @Inject
    @Channel("gas")
    Emitter<String> gasEmitter;

    @Inject
    @Channel("pollution")
    Emitter<String> pollutionEmitter;

    public void sendGas(String data) {
        System.out.println(data);
        CompletionStage<Void> t = gasEmitter.send(data);
    }

    public void sendPollution(String data) {
        System.out.println("Send" +  data);
        pollutionEmitter.send(data);
    }
}
