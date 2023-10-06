package no.fintlabs.service;


import lombok.extern.slf4j.Slf4j;
import no.fintlabs.adapter.models.AdapterCapability;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class AdapterResourceHandler {

    private final AdapterCapability adapterCapability;

    public AdapterResourceHandler(AdapterCapability adapterCapability) {
        this.adapterCapability = adapterCapability;
        log.info("Service created for " + adapterCapability.getResourceName());
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void metode() {
        log.info("Ask for.. " + adapterCapability.getResourceName());
    }

    // Todo: Call GET_ALL etc...
}
