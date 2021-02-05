
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim21.PortalVlasti.soap.service.rescript;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim21.PortalVlasti.service.RescriptService;
import tim21.PortalVlasti.soap.dto.TResponse;
import tim21.PortalVlasti.soap.dto.rescript.ResenjeRoot;
import tim21.PortalVlasti.soap.dto.rescript.TResenje;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T12:32:07.576+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "RescriptService",
                      portName = "RescriptServiceSoapBinding",
                      targetNamespace = "http://www.resenje.com",
                      wsdlLocation = "classpath:wsdl/Rescript.wsdl",
                      endpointInterface = "tim21.PortalVlasti.soap.service.rescript.RescriptServicePortType")
@Service
public class RescriptServiceSoapBindingImpl implements RescriptServicePortType {

    @Autowired
    RescriptService rescriptService;

    private static final Logger LOG = Logger.getLogger(RescriptServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.resenje.RescriptServicePortType#submitRescript(com.resenje.TResenje resenje)*
     */
    public TResponse submitRescript(TResenje resenje) {
        LOG.info("Executing operation submitRescript");
        System.out.println(resenje);

        TResponse response = new TResponse();
        response.setStatus("FAILED");
        try {

            ResenjeRoot root = new ResenjeRoot();
            root.setResenje(resenje);

            System.out.println(resenje);
            System.out.println("ovde printam resenje" + root);
            ResenjeRoot created = rescriptService.create(root);

            if (created != null) {
                response.setStatus("SUCCESS");
                return response;
            }

            response.setStatus("FAILED");

            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}