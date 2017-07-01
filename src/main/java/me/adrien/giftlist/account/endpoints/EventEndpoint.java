package me.adrien.giftlist.account.endpoints;

import me.adrien.giftlist.account.models.Child;
import me.adrien.giftlist.account.models.Event;
import me.adrien.giftlist.account.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by adrien on 24/06/2017.
 */
@Component
@Path("/event")
public class EventEndpoint {

    @Autowired
    EventRepository eventRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> get() {
        return this.eventRepository.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Event post(){
        List<Child> childList = new ArrayList<>();
        childList.add(new Child(UUID.randomUUID().toString(), "adrien", "Adrien"));
        childList.add(new Child(UUID.randomUUID().toString(), "melanie", "Mélanie"));
        childList.add(new Child(UUID.randomUUID().toString(), "yaelle", "Yaëlle"));
        childList.add(new Child(UUID.randomUUID().toString(), "eline", "Éline"));

        Event event = new Event(UUID.randomUUID().toString(), "noel", "adrien", childList
                , new Date(), new Date());

        return this.eventRepository.save(event);
    }
}