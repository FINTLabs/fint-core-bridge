package no.fintlabs.service;

import jakarta.annotation.PostConstruct;
import no.fintlabs.config.AdapterConfig;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AdapterService {

    private final AdapterConfig adapterProperties;
    private final GenericApplicationContext applicationContext;

    public AdapterService(AdapterConfig adapterProperties, GenericApplicationContext applicationContext) {
        this.adapterProperties = adapterProperties;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void test() {
        adapterProperties.getCapabilities().values().forEach(adapterCapability -> {
            applicationContext.registerBean(
                    "adapterCability " + adapterCapability.getResourceName(),
                    ScheduleService.class,
                    () -> new ScheduleService(adapterCapability)
            );
        });
    }

}
