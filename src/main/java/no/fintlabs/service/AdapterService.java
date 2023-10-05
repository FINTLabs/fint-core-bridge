package no.fintlabs.service;

import no.fintlabs.config.AdapterConfig;
import org.springframework.stereotype.Service;

@Service
public class AdapterService {

    private final AdapterConfig adapterProperties;

    public AdapterService(AdapterConfig adapterProperties) {
        this.adapterProperties = adapterProperties;
    }




}
