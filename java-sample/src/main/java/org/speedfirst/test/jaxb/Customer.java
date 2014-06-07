package org.speedfirst.test.jaxb;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mycus", namespace = "http://sample.speedfirst.org/jaxb")
public class Customer {

    private String name;

    private int age;

    private int id;

    @XmlElement(namespace = "http://sample.speedfirst.org/jaxb/foo")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(namespace = "http://sample.speedfirst.org/jaxb/bar")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
