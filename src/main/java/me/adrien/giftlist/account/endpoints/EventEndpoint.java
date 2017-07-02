package me.adrien.giftlist.account.endpoints;

import me.adrien.giftlist.account.models.Event;
import me.adrien.giftlist.account.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Created by adrien on 24/06/2017.
 */
@Component
@Path("/event")
public class EventEndpoint {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    MongoOperations mongoOperation;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> get(@HeaderParam(HttpHeaders.REFERER) String referer) {
        Query query = new Query();
        if(StringUtils.isEmpty(referer)){
            referer = "localhost";
        }
        query.addCriteria(Criteria.where("dnsName").is(referer)
                .and("start").lte(new Date())
                .and("end").gte(new Date()));
        return this.mongoOperation.find(query, Event.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Event post(final Event event){
        return this.eventRepository.save(event);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(final Event event) {
        this.eventRepository.delete(event);
    }
}