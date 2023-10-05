//package samtykke.event;
//
//import lombok.extern.slf4j.Slf4j;
//import no.fint.model.resource.personvern.samtykke.SamtykkeResource;
//import no.fintlabs.adapter.config.AdapterProperties;
//import no.fintlabs.adapter.events.EventSubscriber;
//import no.fintlabs.adapter.models.ResponseFintEvent;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Slf4j
//@Service
//public class SamtykkeEventSubscriber extends EventSubscriber<SamtykkeResource, SamtykkeEventPublisher> {
//
//    protected SamtykkeEventSubscriber(WebClient webClient, AdapterProperties adapterProperties, SamtykkeEventPublisher publisher) {
//        super(webClient, adapterProperties, publisher, "samtykke");
//    }
//
//    @Override
//    protected void responsePostingEvent(ResponseEntity<Void> response, ResponseFintEvent<SamtykkeResource> responseFintEvent) {
//        log.info("Posting response for event {} returned {}.", responseFintEvent.getCorrId(), response.getStatusCode());
//    }
//
//}
