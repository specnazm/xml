
package tim21.PortalPoverenika.model.silenceAppeal;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zalbaCutanje" type="{http://www.zalbacutanje.com}TZalbaCutanje"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zalbaCutanje"
})
@XmlRootElement(name = "ZalbaCutanjeRoot")
public class ZalbaCutanjeRoot {

    @XmlElement(required = true)
    protected TZalbaCutanje zalbaCutanje;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the zalbaCutanje property.
     * 
     * @return
     *     possible object is
     *     {@link TZalbaCutanje }
     *     
     */
    public TZalbaCutanje getZalbaCutanje() {
        return zalbaCutanje;
    }

    /**
     * Sets the value of the zalbaCutanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZalbaCutanje }
     *     
     */
    public void setZalbaCutanje(TZalbaCutanje value) {
        this.zalbaCutanje = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
