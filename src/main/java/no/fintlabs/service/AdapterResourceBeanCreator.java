package no.fintlabs.service;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.config.AdapterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Slf4j
@Configuration
public class AdapterResourceBeanCreator {

    private final AdapterConfig adapterProperties;

    private final GenericApplicationContext applicationContext;

    public AdapterResourceBeanCreator(AdapterConfig adapterProperties, GenericApplicationContext applicationContext) {
        this.adapterProperties = adapterProperties;
        this.applicationContext = applicationContext;

        registerBeans();
    }

    public void registerBeans() {
        adapterProperties.getCapabilities().values().forEach(adapterCapability -> {
            AdapterCapabilityFactoryBean factoryBean = new AdapterCapabilityFactoryBean();
            factoryBean.setAdapterCapability(adapterCapability);
            String beanName = "SchedulingService" + adapterCapability.getResourceName();
            log.debug("Registering bean {}", beanName);
            applicationContext.registerBean(beanName, AdapterCapabilityFactoryBean.class, () -> factoryBean);
        });
    }
}
