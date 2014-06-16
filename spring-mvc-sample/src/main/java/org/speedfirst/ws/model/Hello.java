package org.speedfirst.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Hello {

    private String name;

    private Date date;

    public Hello() {
        // necessary for JAXB
    }

    public Hello(String name) {
        this.name = name;
        date = new Date();
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public Date getDate() {
        return date;
    }
}
