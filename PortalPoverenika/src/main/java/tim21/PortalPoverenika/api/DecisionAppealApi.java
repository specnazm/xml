package tim21.PortalPoverenika.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.dto.decisionAppealFilter.DecisionAppealFilter;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.model.lists.SilenceAppealList;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.model.user.User;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.util.ViolationException;
import tim21.PortalPoverenika.util.mappers.DecisionAppealMapper;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalPoverenika.util.constants.RDFConstants.DECISIONAPPEAL_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/decisionappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class DecisionAppealApi {

    @Autowired
    DecisionAppealService appealService;

    @Autowired
    private MetaDataService metaDataService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaRoot appealReq) throws IOException, SAXException {

        try {
            String requestID = appealReq.getOtherAttributes().get(new QName("href")).split("/")[3];
            boolean requestValid = appealService.checkRequestId(requestID);
            if (!requestValid) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ZalbaRoot appeal = DecisionAppealMapper.addStaticText(appealReq);
        appeal = appealService.create(appeal);
        if (appeal != null) {
            return new ResponseEntity<>(appeal, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DecisionAppealList> getAllAppeals() {
        DecisionAppealList appeals = new DecisionAppealList();
        try {
            appeals = appealService.getAll();

            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getAppeal(@PathVariable String ID) {
        ZalbaRoot appeal = appealService.getOne(ID);
        if (appeal != null)
            return new ResponseEntity(appeal, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/search/{KW}", method = RequestMethod.GET)
    public ResponseEntity<DecisionAppealList> searchAppeals(@PathVariable String KW) {
        DecisionAppealList appeals = new DecisionAppealList();
        try {
            appeals = appealService.search(KW);
            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/search/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody DecisionAppealFilter filter) {
        List<ZalbaRoot> appeals = new ArrayList<ZalbaRoot>();
        List<String> res = new ArrayList<String>();
        List<String> filterVals = Arrays.asList(filter.getSubmitterStreet(), filter.getSubmitterCity(), filter.getSubmitterName(), filter.getSubmitterLastname(), filter.getRequestId(), filter.getRequestDate(),
                filter.getRecipientStreet(), filter.getRecipientCity(), filter.getAppealDate(), filter.getSubmitterType());
        try {
            res = metaDataService.filter("Zalbe", filterVals);
            for (String key : res) {
                String id = key.split("zalbe")[1].substring(1);    // format keya je http://zalbe/234213123
                appeals.add(appealService.getOne(id));
            }
            DecisionAppealList response = new DecisionAppealList(appeals);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/rdf/{ID}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = DECISIONAPPEAL_RDF_RESOURCES + ID + ".rdf";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/xml; charset=utf-8");
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".rdf");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/json/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> metaExportJSON(@PathVariable Long ID) throws IOException {

        String path = DECISIONAPPEAL_RDF_RESOURCES + ID + ".json";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".json");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> dropAppeal(@PathVariable String ID) {
        boolean removed = false;
        try {
            removed = appealService.dropAppeal(ID);
            if (removed) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (ViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping(value = "/all",method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<SilenceAppealList> getAllAppealsByUser() {
        DecisionAppealList appeals = new DecisionAppealList();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            appeals = appealService.getAllByUser(user.getEmail().getValue());

            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping( value="/notify/{ID}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> informOfficial(@PathVariable String ID)  {

        //proveri jel postoji zalba
        ZalbaRoot appeal = appealService.getOne(ID);

        if (appeal == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            appeal.getOtherAttributes().put(new QName("obavestio"), "true");
            try {
                appealService.save(appeal, ID);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        boolean notified = appealService.notifyOffical(ID);

        if (notified) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{ID}/generate", method = RequestMethod.GET)
    public ResponseEntity<?> generate(@PathVariable String ID, @RequestParam("type") String fileType) {
        String path = null;
        if (fileType.equals("pdf")) {
            path = appealService.generatePdf(ID);
        } else if (fileType.equals("html")) {
            path = appealService.generateHtml(ID);
        }


        if (path == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + "." + fileType);
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}