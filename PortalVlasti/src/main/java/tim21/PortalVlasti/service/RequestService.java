package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.repository.RequestRepository;
import tim21.PortalVlasti.util.Validator;
import tim21.PortalVlasti.util.transformer.PDFTransformer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public static final String XSL_FILE = "src/main/resources/xsl/request.xsl";

    public static final String XSL_FO_FILE = "src/main/resources/xsl/request_fo.xsl";

    public ZahtevRoot create(ZahtevRoot request, String submitterId) throws IOException, SAXException {


        if (Validator.validate(request.getClass(), request)) {

            return requestRepository.create(request, submitterId);
        }
        return null;
    }

    public ZahtevRoot acceptRequest(String id) {
        ZahtevRoot request = getOne(id);
        if (request == null) {
            return null;
        }

        try {
            requestRepository.accept(request);

            return request;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public RequestList getAll() throws XMLDBException, JAXBException {
        List<ZahtevRoot> requests = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = requestRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevRoot request = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            requests.add(request);
        }

        return new RequestList(requests);
    }


    public RequestList search(String keyword) throws XMLDBException, JAXBException {
        List<ZahtevRoot> requests = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = requestRepository.search(keyword);
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevRoot request = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            requests.add(request);
        }
        return new RequestList(requests);
    }

    public long getRejectedNumber() throws XMLDBException, JAXBException {
        return requestRepository.getRejectedNumber();
    }

    public ZahtevRoot getOne(String ID) {
        XMLResource xmlResource = requestRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ZahtevRoot request = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            request = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return request;
    }

    public ZahtevRoot rejectRequest(String id) {
        ZahtevRoot request = getOne(id);
        if (request == null) {
            return null;
        }

        try {
            requestRepository.reject(request);

            return request;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public RequestList getAllByUser(String email) throws XMLDBException, JAXBException {
        List<ZahtevRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = requestRepository.getAllByUser(email);
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevRoot req = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(req);
        }
        return new RequestList(appeals);
    }

    public String generatePdf(String ID) {
        XMLResource inf = requestRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(inf == null)
            return null;

        String pdfPath ="src/main/resources/static/request/request_" + ID + ".pdf";
        try {
            transformer.generatePDF(inf.getContent().toString(), pdfPath, XSL_FO_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return pdfPath;
    }

    public String generateHtml(String ID) {
        XMLResource inf = requestRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(inf == null)
            return null;

        String htmlPath ="src/main/resources/static/request/request_" + ID + ".html";
        try {
            transformer.generateHTML(inf.getContent().toString(), htmlPath, XSL_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return htmlPath;
    }
}
