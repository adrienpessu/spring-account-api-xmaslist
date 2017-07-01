package me.adrien.giftlist.account.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by adrien on 26/06/2017.
 */

public class Child {

    @Id
    public String id;

    @Indexed(unique = true)
    public String name;

    public String displayName;

    public Child() {}

    public Child(String id, String name, String displayName) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
