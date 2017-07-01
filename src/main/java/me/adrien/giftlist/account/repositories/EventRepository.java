package me.adrien.giftlist.account.repositories;

import me.adrien.giftlist.account.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by adrien on 26/06/2017.
 */
public interface EventRepository extends MongoRepository<Event, String> {

    @Override
    List<Event> findAll();

    /*
    Familly create(Familly familly);
    List<Familly> findByDnsName(String dnsName);

    //Supports native JSON query string
    @Query("{dns:'?0'}")
    Familly findCustomByDns(String dns);
    */

}
