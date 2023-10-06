package no.fintlabs.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdapterResourceHandlerInitializer {

    private final List<AdapterResourceHandler> adapterResourceHandlers;

    public AdapterResourceHandlerInitializer(List<AdapterResourceHandler> adapterResourceHandlers) {
        this.adapterResourceHandlers = adapterResourceHandlers;
    }

    @PostConstruct
    public void test() {
        adapterResourceHandlers.forEach(s -> log.info(s.toString()));
    }
}
