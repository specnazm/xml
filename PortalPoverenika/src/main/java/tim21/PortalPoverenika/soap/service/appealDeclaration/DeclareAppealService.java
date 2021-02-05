package tim21.PortalPoverenika.soap.service.appealDeclaration;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T20:03:23.855+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "DeclareAppealService", 
                  wsdlLocation = "classpath:wsdl/IzjasnjavanjeZalba.wsdl",
                  targetNamespace = "http://www.izjasnjavanjezalba.com") 
public class DeclareAppealService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.izjasnjavanjezalba.com", "DeclareAppealService");
    public final static QName DeclareAppealServiceSoapBinding = new QName("http://www.izjasnjavanjezalba.com", "DeclareAppealServiceSoapBinding");
    static {
        URL url = DeclareAppealService.class.getClassLoader().getResource("wsdl/IzjasnjavanjeZalba.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(DeclareAppealService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/IzjasnjavanjeZalba.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public DeclareAppealService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DeclareAppealService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeclareAppealService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public DeclareAppealService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DeclareAppealService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DeclareAppealService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns DeclareAppealServicePortType
     */
    @WebEndpoint(name = "DeclareAppealServiceSoapBinding")
    public DeclareAppealServicePortType getDeclareAppealServiceSoapBinding() {
        return super.getPort(DeclareAppealServiceSoapBinding, DeclareAppealServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DeclareAppealServicePortType
     */
    @WebEndpoint(name = "DeclareAppealServiceSoapBinding")
    public DeclareAppealServicePortType getDeclareAppealServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(DeclareAppealServiceSoapBinding, DeclareAppealServicePortType.class, features);
    }

}