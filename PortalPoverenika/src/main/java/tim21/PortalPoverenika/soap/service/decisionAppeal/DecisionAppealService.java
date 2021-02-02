package tim21.PortalPoverenika.soap.service.decisionAppeal;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-02T01:56:59.949+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "DecisionAppealService", 
                  wsdlLocation = "classpath:wsdl/DecisionAppeal.wsdl",
                  targetNamespace = "http://www.zalbanaodluku.com") 
public class DecisionAppealService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.zalbanaodluku.com", "DecisionAppealService");
    public final static QName DecisionAppealServiceSoapBinding = new QName("http://www.zalbanaodluku.com", "DecisionAppealServiceSoapBinding");
    static {
        URL url = DecisionAppealService.class.getClassLoader().getResource("wsdl/DecisionAppeal.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(DecisionAppealService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/DecisionAppeal.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public DecisionAppealService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DecisionAppealService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DecisionAppealService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public DecisionAppealService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DecisionAppealService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DecisionAppealService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns DecisionAppealServicePortType
     */
    @WebEndpoint(name = "DecisionAppealServiceSoapBinding")
    public DecisionAppealServicePortType getDecisionAppealServiceSoapBinding() {
        return super.getPort(DecisionAppealServiceSoapBinding, DecisionAppealServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DecisionAppealServicePortType
     */
    @WebEndpoint(name = "DecisionAppealServiceSoapBinding")
    public DecisionAppealServicePortType getDecisionAppealServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(DecisionAppealServiceSoapBinding, DecisionAppealServicePortType.class, features);
    }

}
