package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import tim21.PortalVlasti.model.information.ObavestenjeRoot;
import tim21.PortalVlasti.model.lists.InformationList;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.repository.InformationRepository;
import tim21.PortalVlasti.soap.client.MailClient;
import tim21.PortalVlasti.soap.dto.MailRequest;
import tim21.PortalVlasti.util.Validator;
import tim21.PortalVlasti.repository.InformationRepository;
import tim21.PortalVlasti.util.transformer.PDFTransformer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class InformationService {

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    RequestService requestService;

    @Autowired
    MailClient mailClient;

    @Autowired
    private Environment env;


    public static final String XSL_FILE = "src/main/resources/xsl/information.xsl";

    public static final String XSL_FO_FILE = "src/main/resources/xsl/information_fo.xsl";

    public ObavestenjeRoot create(ObavestenjeRoot information) throws IOException, SAXException {


        if (Validator.validate(information.getClass(), information)) {

            String requestID = information.getOtherAttributes().get(new QName("href")).split("zahtevi")[1].substring(1);
            ZahtevRoot req = requestService.acceptRequest(requestID);
            if(req == null){
                return null;
            }

            ObavestenjeRoot created = informationRepository.create(information);

            String ID = information.getOtherAttributes().get(new QName("about")).split("/")[3];

            generateHtml(ID);
            generatePdf(ID);

            MailRequest request = new MailRequest();
            request.setTo(information.getOtherAttributes().get(new QName("sendTo")).split("users")[1].substring(1));
            request.setSubject("[OBAVESTENJE] Zahtevu promenjen status");
            request.setContent("Obavestavamo vas da je zahtevu " + requestID + " promenjen status u 'ODOBRENO'. \n\n" +
                    "Admin tim eUprave");


            Path pdfPath = Paths.get("src/main/resources/static/information/information_" + ID + ".pdf");
            Path htmlPath = Paths.get("src/main/resources/static/information/information_" + ID + ".html");
            try {
                byte[] byteArr = Files.readAllBytes(pdfPath);
                request.setFile(byteArr);

                byteArr = Files.readAllBytes(htmlPath);
                request.setHtml(byteArr);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("tim21.PortalVlasti.soap.dto");
            mailClient.setMarshaller(marshaller);
            mailClient.setUnmarshaller(marshaller);

            boolean sent = mailClient.sendMail(request);
            if (sent) {
                return created;
            }

        }
        return null;
    }




    public InformationList getAll() throws XMLDBException, JAXBException {
        List<ObavestenjeRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = informationRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ObavestenjeRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ObavestenjeRoot appeal = (ObavestenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new InformationList(appeals);
    }

    public InformationList getAllByUser(String email) throws XMLDBException, JAXBException {
        List<ObavestenjeRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = informationRepository.getAllByUser(email);
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ObavestenjeRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ObavestenjeRoot appeal = (ObavestenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new InformationList(appeals);
    }

    public ObavestenjeRoot getOne(String ID) {
        XMLResource xmlResource = informationRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ObavestenjeRoot appeal = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ObavestenjeRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            appeal = (ObavestenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return appeal;
    }

    public String generatePdf(String ID) {
        XMLResource inf = informationRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(inf == null)
            return null;

        String pdfPath ="src/main/resources/static/information/information_" + ID + ".pdf";
        try {
            transformer.generatePDF(inf.getContent().toString(), pdfPath, XSL_FO_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return pdfPath;
    }

    public String generateHtml(String ID) {
        XMLResource inf = informationRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(inf == null)
            return null;

        String htmlPath ="src/main/resources/static/information/information_" + ID + ".html";
        try {
            transformer.generateHTML(inf.getContent().toString(), htmlPath, XSL_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return htmlPath;
    }

}
