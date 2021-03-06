package tim21.PortalVlasti.service;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalVlasti.model.lists.AppealAnnouncementList;
import tim21.PortalVlasti.repository.AppealAnnouncementRepository;
import tim21.PortalVlasti.soap.client.AppealDeclarationClient;
import tim21.PortalVlasti.soap.dto.appealDeclaration.IzjasnjavanjeZalba;
import tim21.PortalVlasti.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class AppealAnnouncementService {

    @Autowired
    AppealAnnouncementRepository appealAnnouncementRepository;

    @Autowired
    AppealDeclarationClient declarationClient;

    @Autowired
    Environment env;

    public ObavestenjeZalba create(ObavestenjeZalba announcement) throws IOException, SAXException {


        if (Validator.validate(announcement.getClass(), announcement)) {

            return appealAnnouncementRepository.create(announcement);
        }
        return null;
    }


    public AppealAnnouncementList getAll() throws XMLDBException, JAXBException {
        List<ObavestenjeZalba> announcements = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealAnnouncementRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ObavestenjeZalba.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ObavestenjeZalba announcement = (ObavestenjeZalba) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            announcements.add(announcement);
        }

        return new AppealAnnouncementList(announcements);
    }

    public boolean sendDeclaration(IzjasnjavanjeZalba declaration) {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("tim21.PortalVlasti.soap.dto.appealDeclaration");

        declarationClient.setDefaultUri(env.getProperty("portal_vlasti"));
        declarationClient.setMarshaller(marshaller);

        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setContextPath("tim21.PortalVlasti.soap.dto");
        declarationClient.setUnmarshaller(unmarshaller);

        return declarationClient.submitAppealDeclaration(declaration);

    }
}
