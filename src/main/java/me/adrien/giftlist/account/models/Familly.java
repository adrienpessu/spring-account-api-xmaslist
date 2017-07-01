package me.adrien.giftlist.account.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by adrien on 26/06/2017.
 */
public class Familly {

    @Id
    public String id;

    @Indexed(unique = true)
    public String dnsName;

    public List<Child> childs;

    public Familly() {}

    public Familly(String id, String dnsName, List<Child> childs) {
        this.id = id;
        this.dnsName = dnsName;
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Familly{" +
                "id='" + id + '\'' +
                ", dnsName='" + dnsName + '\'' +
                ", childs=" + childs +
                '}';
    }
}
