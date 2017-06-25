package me.adrien.giftlist.account.endpoints;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by adrien on 24/06/2017.
 */
@Component
@Path("/hello")
public class HelloWorldEndpoint {
    @GET
    @Path("/world")
    public String test() {
        return "Hello world!";
    }
}