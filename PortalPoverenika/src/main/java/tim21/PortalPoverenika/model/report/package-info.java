@javax.xml.bind.annotation.XmlSchema(elementFormDefault = XmlNsForm.QUALIFIED,
        namespace = "http://www.izvestaj.com",
        xmlns={
                @XmlNs(prefix="sh", namespaceURI="http://www.shared.com"),
                @XmlNs(prefix="pred", namespaceURI="http://www.tim21.com/predicate/")})


package tim21.PortalPoverenika.model.report;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;