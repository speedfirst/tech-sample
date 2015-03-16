@XmlSchema(
        elementFormDefault= XmlNsForm.QUALIFIED,
        namespace = "http://sample.speedfirst.org/jaxb",
        xmlns = {   @XmlNs(prefix = "", namespaceURI = "http://sample.speedfirst.org/jaxb"),
                    @XmlNs(prefix = "foo", namespaceURI = "http://sample.speedfirst.org/jaxb/foo"),
                    @XmlNs(prefix = "bar", namespaceURI = "http://sample.speedfirst.org/jaxb/bar")}
)
package org.speedfirst.sample.jaxb;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;