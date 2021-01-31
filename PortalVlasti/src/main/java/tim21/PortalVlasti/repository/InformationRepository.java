package tim21.PortalVlasti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.db.ExistManager;
import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.util.IdGenerator;
import tim21.PortalVlasti.util.constants.XSDConstants;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalVlasti.util.constants.DBConstants.INFORMATION_COLLECTION_URI;
import static tim21.PortalVlasti.util.constants.NamespaceConstants.INFORMATION_TARGET_NAMESPACE;

@Repository
public class InformationRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(Obavestenje inf) {
        try {
            String id = IdGenerator.generateDocumentID(IdGenerator.generate(XSDConstants.INFORMATION), XSDConstants.INFORMATION);
            Map<QName, String> attrributes = inf.getOtherAttributes();
            attrributes.put(new QName("id"), id);

            return existManager.store(INFORMATION_COLLECTION_URI, id, inf, "obavestenja");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(INFORMATION_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(INFORMATION_COLLECTION_URI, "/Obavestenje", INFORMATION_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}