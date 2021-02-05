package tim21.PortalPoverenika.soap.service.appealDeclaration;

import tim21.PortalPoverenika.model.appealDeclaration.ObjectFactory;
import tim21.PortalPoverenika.model.appealDeclaration.TIzjasnjavanjeZalbaDok;
import tim21.PortalPoverenika.soap.dto.TResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-05T20:03:23.855+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.izjasnjavanjezalba.com", name = "DeclareAppealServicePortType")
@XmlSeeAlso({tim21.PortalPoverenika.soap.dto.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DeclareAppealServicePortType {

    @WebMethod(action = "http://www.izjasnjavanjezalba.com/ws/declareAppealService")
    @WebResult(name = "response", targetNamespace = "", partName = "response")
    public TResponse declareAboutAppeal(
        @WebParam(partName = "IzjasnjavanjeZalbaDokument", name = "IzjasnjavanjeZalbaDokument", targetNamespace = "")
                TIzjasnjavanjeZalbaDok izjasnjavanjeZalbaDokument
    );
}