
package tim21.PortalPoverenika.model.report;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.izvestaj package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.izvestaj
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TIzvestaj }
     * 
     */
    public TIzvestaj createTIzvestaj() {
        return new TIzvestaj();
    }

    /**
     * Create an instance of {@link IzvestajRoot }
     * 
     */
    public IzvestajRoot createIzvestajRoot() {
        return new IzvestajRoot();
    }

    /**
     * Create an instance of {@link ReportList }
     * 
     */
    public ReportList createReportList() {
        return new ReportList();
    }

    /**
     * Create an instance of {@link TResponse }
     * 
     */
    public TResponse createTResponse() {
        return new TResponse();
    }

    /**
     * Create an instance of {@link TIzvestaj.FizickoLice }
     * 
     */
    public TIzvestaj.FizickoLice createTIzvestajFizickoLice() {
        return new TIzvestaj.FizickoLice();
    }

    /**
     * Create an instance of {@link TIzvestaj.PravnoLice }
     * 
     */
    public TIzvestaj.PravnoLice createTIzvestajPravnoLice() {
        return new TIzvestaj.PravnoLice();
    }

}
