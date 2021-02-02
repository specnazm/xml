package tim21.PortalPoverenika.soap.service.silenceAppeal;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-02T12:51:09.334+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "SilenceAppealService", 
                  wsdlLocation = "classpath:wsdl/SilenceAppeal.wsdl",
                  targetNamespace = "http://www.zalbacutanje.com") 
public class SilenceAppealService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.zalbacutanje.com", "SilenceAppealService");
    public final static QName SilenceAppealServiceSoapBinding = new QName("http://www.zalbacutanje.com", "SilenceAppealServiceSoapBinding");
    static {
        URL url = SilenceAppealService.class.getClassLoader().getResource("wsdl/SilenceAppeal.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(SilenceAppealService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/SilenceAppeal.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public SilenceAppealService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SilenceAppealService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SilenceAppealService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public SilenceAppealService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SilenceAppealService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SilenceAppealService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns SilenceAppealServicePortType
     */
    @WebEndpoint(name = "SilenceAppealServiceSoapBinding")
    public SilenceAppealServicePortType getSilenceAppealServiceSoapBinding() {
        return super.getPort(SilenceAppealServiceSoapBinding, SilenceAppealServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SilenceAppealServicePortType
     */
    @WebEndpoint(name = "SilenceAppealServiceSoapBinding")
    public SilenceAppealServicePortType getSilenceAppealServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(SilenceAppealServiceSoapBinding, SilenceAppealServicePortType.class, features);
    }

}
