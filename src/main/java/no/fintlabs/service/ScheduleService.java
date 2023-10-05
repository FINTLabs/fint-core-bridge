package no.fintlabs.service;


import lombok.extern.slf4j.Slf4j;
import no.fintlabs.adapter.models.AdapterCapability;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class ScheduleService {

    private final AdapterCapability adapterCapability;

    public ScheduleService(AdapterCapability adapterCapability) {
        this.adapterCapability = adapterCapability;
    }

    @Scheduled(initialDelay = 1, fixedDelay = 5)
    private void metode() {
        log.info("Ask for.. " + adapterCapability.getResourceName());
    }

}
