package me.adrien.giftlist.account;

import me.adrien.giftlist.account.endpoints.HelloWorldEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by adrien on 24/06/2017.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
        register(HelloWorldEndpoint.class);
    }
}