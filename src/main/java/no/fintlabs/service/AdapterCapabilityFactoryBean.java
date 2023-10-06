package no.fintlabs.service;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.adapter.models.AdapterCapability;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

@Slf4j
public class AdapterCapabilityFactoryBean implements FactoryBean<AdapterResourceHandler>, InitializingBean {

    private AdapterCapability adapterCapability;

    public void setAdapterCapability(AdapterCapability adapterCapability) {
        this.adapterCapability = adapterCapability;
    }

    @Override
    public AdapterResourceHandler getObject() throws Exception {
        var service = new AdapterResourceHandler(adapterCapability);
        log.debug("Service created for " + adapterCapability.getResourceName());
        return service;
    }

    @Override
    public Class<?> getObjectType() {
        return AdapterResourceHandler.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(adapterCapability, "The 'adapterCapability' property must be set");
    }
}
