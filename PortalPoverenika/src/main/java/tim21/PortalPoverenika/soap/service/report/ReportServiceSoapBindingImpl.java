
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim21.PortalPoverenika.soap.service.report;

import org.apache.xmlrpc.webserver.ServletWebServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import tim21.PortalPoverenika.model.report.IzvestajRoot;
import tim21.PortalPoverenika.model.report.TIzvestaj;
import tim21.PortalPoverenika.model.report.TResponse;
import tim21.PortalPoverenika.repository.ReportRepository;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.service.SilenceAppealService;
import tim21.PortalPoverenika.service.ReportDataService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-03T18:20:06.137+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "ReportService",
                      portName = "ReportServiceSoapBinding",
                      targetNamespace = "http://www.izvestaj.com",
                      wsdlLocation = "classpath:wsdl/Report.wsdl",
                      endpointInterface = "tim21.PortalPoverenika.soap.service.report.ReportServicePortType")

@Service
public class ReportServiceSoapBindingImpl implements ReportServicePortType {

    private static final Logger LOG = Logger.getLogger(ReportServiceSoapBindingImpl.class.getName());

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    DecisionAppealService decisionAppealService;

    @Autowired
    SilenceAppealService silenceAppealService;

    @Autowired
    ReportDataService reportService;

    /* (non-Javadoc)
     * @see com.izvestaj.ReportServicePortType#getAppealStats(javax.xml.datatype.XMLGregorianCalendar year)*
     */
    public TIzvestaj getAppealStats() {
        LOG.info("Executing operation getAppealStats");
        try {
            String year = Calendar.getInstance().get(Calendar.YEAR) + "";
            List<String> filterDecFizicko = Arrays.asList("","","","","","","","",year,"FIZICKO_LICE");
            List<String> filterDecPravno = Arrays.asList("","","","","","","","",year,"PRAVNO_LICE");
            List<String> filterSil = Arrays.asList("","","","","","","","","","",year);

            List<String> decKeysFizicko = metaDataService.filter("zalbe", filterDecFizicko);
            List<String> decKeysPravno = metaDataService.filter("zalbe", filterDecPravno);
            List<String> silKeys = metaDataService.filter("zalbeCutanje", filterSil);

            TIzvestaj ret = new TIzvestaj();

            ret.setFizickoLice(new TIzvestaj.FizickoLice());
            ret.setPravnoLice(new TIzvestaj.PravnoLice());
            ret.getFizickoLice().setBrojZalbiOdluka(decKeysFizicko.size());
            ret.getFizickoLice().setBrojZalbiCutanje(silKeys.size());

            ret.getPravnoLice().setBrojZalbiOdluka(decKeysPravno.size());
            ret.getPravnoLice().setBrojZalbiCutanje(0);

            return ret;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.izvestaj.ReportServicePortType#submitReport(com.izvestaj.TIzvestaj izvestaj)*
     */
    public TResponse submitReport(TIzvestaj izvestaj) {
        LOG.info("Executing operation submitReport");

        IzvestajRoot izvestajRoot = new IzvestajRoot();
        izvestajRoot.setIzvestaj(izvestaj);

        try {
            IzvestajRoot ret = reportService.create(izvestajRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TResponse _return = new TResponse();
        try {

            _return.setStatus("SUCCESS");
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            _return.setStatus("FAILED");
            return _return;
            
        }
    }

}
