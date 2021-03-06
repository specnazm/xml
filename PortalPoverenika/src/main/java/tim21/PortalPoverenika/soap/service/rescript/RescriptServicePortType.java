package tim21.PortalPoverenika.soap.service.rescript;

import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.ObjectFactory;
import tim21.PortalPoverenika.model.rescript.TResenje;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-02T15:16:01.955+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.resenje.com", name = "RescriptServicePortType")
@XmlSeeAlso({ObjectFactory.class, tim21.PortalPoverenika.model.rescript.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface RescriptServicePortType {

    @WebMethod(action = "http://www.resenje.com/ws/getAll")
    @WebResult(name = "response", targetNamespace = "", partName = "response")
    public RescriptList getAll();

    @WebMethod(action = "http://www.resenje.com/ws/getRescriptById")
    @WebResult(name = "resenje", targetNamespace = "", partName = "resenje")
    public TResenje getRescriptById(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        String id
    );
}
