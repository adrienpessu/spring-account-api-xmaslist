package me.adrien.giftlist.account.models;

import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by adrien on 26/06/2017.
 */
public class Event {

    @Id
    public String id;

    public String name;

    public String famillyId;

    public List<Child> childs;

    public Date start;

    public Date end;

    public Event(){}

    public Event(String id, String name, String famillyId, List<Child> childs, Date start, Date end) {
        this.id = id;
        this.name = name;
        this.famillyId = famillyId;
        this.childs = childs;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", famillyId='" + famillyId + '\'' +
                ", childs=" + childs +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
