package org.speedfirst.test.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBSample {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Customer customer = new Customer();
        customer.setAge(30);
        customer.setName("Andy");
        customer.setId(19303153);

        marshaller.marshal(customer, System.out);

    }
}
