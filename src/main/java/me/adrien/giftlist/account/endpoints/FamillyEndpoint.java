package me.adrien.giftlist.account.endpoints;

import me.adrien.giftlist.account.models.Child;
import me.adrien.giftlist.account.models.Familly;
import me.adrien.giftlist.account.repositories.FamillyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by adrien on 24/06/2017.
 */
@Component
@Path("/familly")
public class FamillyEndpoint {

    @Autowired
    FamillyRepository famillyRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {

        return famillyRepository.findAll().toString();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String post(){
        List<Child> childList = new ArrayList<>();
        childList.add(new Child(UUID.randomUUID().toString(), "adrien", "Adrien"));
        childList.add(new Child(UUID.randomUUID().toString(), "melanie", "Mélanie"));
        childList.add(new Child(UUID.randomUUID().toString(), "yaelle", "Yaëlle"));
        childList.add(new Child(UUID.randomUUID().toString(), "eline", "Éline"));

        Familly familly = new Familly(UUID.randomUUID().toString(), "gift.adrien.me", childList);
        final Familly save = famillyRepository.save(familly);
        return save.toString();
    }
}