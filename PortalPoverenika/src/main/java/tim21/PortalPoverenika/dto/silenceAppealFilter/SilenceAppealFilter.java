
package tim21.PortalPoverenika.dto.silenceAppealFilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecipientStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterLastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestDetails" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AppealDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recipientStreet",
    "recipientCity",
    "requestId",
    "submitterName",
    "submitterLastname",
    "submitterCity",
    "submitterStreet",
    "requestDate",
    "requestDetails",
    "appealDate",
    "authorityName"
})
@XmlRootElement(name = "SilenceAppealFilter", namespace = "http://www.shared.com")
public class SilenceAppealFilter {

    @XmlElement(name = "RecipientStreet", namespace = "http://www.shared.com", required = true)
    protected String recipientStreet;
    @XmlElement(name = "RecipientCity", namespace = "http://www.shared.com", required = true)
    protected String recipientCity;
    @XmlElement(name = "RequestId", namespace = "http://www.shared.com", required = true)
    protected String requestId;
    @XmlElement(name = "SubmitterName", namespace = "http://www.shared.com", required = true)
    protected String submitterName;
    @XmlElement(name = "SubmitterLastname", namespace = "http://www.shared.com", required = true)
    protected String submitterLastname;
    @XmlElement(name = "SubmitterCity", namespace = "http://www.shared.com", required = true)
    protected String submitterCity;
    @XmlElement(name = "SubmitterStreet", namespace = "http://www.shared.com", required = true)
    protected String submitterStreet;
    @XmlElement(name = "RequestDate", namespace = "http://www.shared.com", required = true)
    protected String requestDate;
    @XmlElement(name = "RequestDetails", namespace = "http://www.shared.com", required = true)
    protected String requestDetails;
    @XmlElement(name = "AppealDate", namespace = "http://www.shared.com", required = true)
    protected String appealDate;
    @XmlElement(name = "AuthorityName", namespace = "http://www.shared.com", required = true)
    protected String authorityName;

    /**
     * Gets the value of the recipientStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientStreet() {
        return recipientStreet;
    }

    /**
     * Sets the value of the recipientStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientStreet(String value) {
        this.recipientStreet = value;
    }

    /**
     * Gets the value of the recipientCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientCity() {
        return recipientCity;
    }

    /**
     * Sets the value of the recipientCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientCity(String value) {
        this.recipientCity = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the submitterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterName() {
        return submitterName;
    }

    /**
     * Sets the value of the submitterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterName(String value) {
        this.submitterName = value;
    }

    /**
     * Gets the value of the submitterLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterLastname() {
        return submitterLastname;
    }

    /**
     * Sets the value of the submitterLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterLastname(String value) {
        this.submitterLastname = value;
    }

    /**
     * Gets the value of the submitterCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterCity() {
        return submitterCity;
    }

    /**
     * Sets the value of the submitterCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterCity(String value) {
        this.submitterCity = value;
    }

    /**
     * Gets the value of the submitterStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterStreet() {
        return submitterStreet;
    }

    /**
     * Sets the value of the submitterStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterStreet(String value) {
        this.submitterStreet = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDate(String value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the requestDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDetails() {
        return requestDetails;
    }

    /**
     * Sets the value of the requestDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDetails(String value) {
        this.requestDetails = value;
    }

    /**
     * Gets the value of the appealDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppealDate() {
        return appealDate;
    }

    /**
     * Sets the value of the appealDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppealDate(String value) {
        this.appealDate = value;
    }

    /**
     * Gets the value of the authorityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * Sets the value of the authorityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityName(String value) {
        this.authorityName = value;
    }

}
