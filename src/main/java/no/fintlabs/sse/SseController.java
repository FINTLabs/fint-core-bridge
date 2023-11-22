package no.fintlabs.sse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.HeaderConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@RequestMapping(value = "/sse", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequiredArgsConstructor
public class SseController {

    private final SseService sseService;

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> subscribe(
            @RequestHeader(HeaderConstants.ORG_ID) String orgId,
            @RequestHeader(HeaderConstants.CLIENT) String client,
            @PathVariable String id) {
        SseEmitter emitter = sseService.subscribe(id, orgId, client);
        return ResponseEntity.ok(emitter);
    }

//    @GetMapping("/clients")
//    public List<SseOrg> getClients() {
//        Map<String, FintSseEmitters> clients = sseService.getSseClients();
//        List<SseOrg> orgs = new ArrayList<>();
//        clients.forEach((key, value) -> {
//            List<SseClient> sseClients = new ArrayList<>();
//            value.forEach(emitter -> sseClients.add(new SseClient(emitter.getRegistered(), emitter.getId(), emitter.getClient(), emitter.getEventCounter().get())));
//
//            orgs.add(new SseOrg(props.getContextPath(), key, sseClients));
//        });
//        return orgs;
//    }

//    @DeleteMapping("/clients")
//    public void removeSseClients() {
//        sseService.removeAll();
//    }

}
