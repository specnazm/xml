
package tim21.PortalVlasti.model.information;

import tim21.PortalVlasti.model.shared.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim21.PortalVlasti.model.information package. 
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

    private final static QName _ObavestenjeOrgan_QNAME = new QName("http://www.obavestenje.com", "Organ");
    private final static QName _ObavestenjePodnaslov_QNAME = new QName("http://www.obavestenje.com", "Podnaslov");
    private final static QName _ObavestenjeDostavljeno_QNAME = new QName("http://www.obavestenje.com", "Dostavljeno");
    private final static QName _ObavestenjeOdgovor_QNAME = new QName("http://www.obavestenje.com", "Odgovor");
    private final static QName _ObavestenjeBrojPredmeta_QNAME = new QName("http://www.obavestenje.com", "Broj_predmeta");
    private final static QName _ObavestenjeNaslov_QNAME = new QName("http://www.obavestenje.com", "Naslov");
    private final static QName _ObavestenjeDatum_QNAME = new QName("http://www.obavestenje.com", "Datum");
    private final static QName _ObavestenjePodaciOPlacanju_QNAME = new QName("http://www.obavestenje.com", "Podaci_o_placanju");
    private final static QName _ObavestenjePodnosilac_QNAME = new QName("http://www.obavestenje.com", "Podnosilac");
    private final static QName _TLokacijaBrojKancelarije_QNAME = new QName("http://www.obavestenje.com", "Broj_kancelarije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalVlasti.model.information
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Obavestenje }
     * 
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TtrazilacInformacije }
     * 
     */
    public TtrazilacInformacije createTtrazilacInformacije() {
        return new TtrazilacInformacije();
    }

    /**
     * Create an instance of {@link TdatumVreme }
     * 
     */
    public TdatumVreme createTdatumVreme() {
        return new TdatumVreme();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju }
     * 
     */
    public Obavestenje.PodaciOPlacanju createObavestenjePodaciOPlacanju() {
        return new Obavestenje.PodaciOPlacanju();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju.PojedinacniTroskovi }
     * 
     */
    public Obavestenje.PodaciOPlacanju.PojedinacniTroskovi createObavestenjePodaciOPlacanjuPojedinacniTroskovi() {
        return new Obavestenje.PodaciOPlacanju.PojedinacniTroskovi();
    }

    /**
     * Create an instance of {@link Obavestenje.Odgovor }
     * 
     */
    public Obavestenje.Odgovor createObavestenjeOdgovor() {
        return new Obavestenje.Odgovor();
    }

    /**
     * Create an instance of {@link Obavestenje.Organ }
     * 
     */
    public Obavestenje.Organ createObavestenjeOrgan() {
        return new Obavestenje.Organ();
    }

    /**
     * Create an instance of {@link Obavestenje.BrojPredmeta }
     * 
     */
    public Obavestenje.BrojPredmeta createObavestenjeBrojPredmeta() {
        return new Obavestenje.BrojPredmeta();
    }

    /**
     * Create an instance of {@link Obavestenje.Datum }
     * 
     */
    public Obavestenje.Datum createObavestenjeDatum() {
        return new Obavestenje.Datum();
    }

    /**
     * Create an instance of {@link Obavestenje.Podnosilac }
     * 
     */
    public Obavestenje.Podnosilac createObavestenjePodnosilac() {
        return new Obavestenje.Podnosilac();
    }

    /**
     * Create an instance of {@link Obavestenje.Dostavljeno }
     * 
     */
    public Obavestenje.Dostavljeno createObavestenjeDostavljeno() {
        return new Obavestenje.Dostavljeno();
    }

    /**
     * Create an instance of {@link TLokacija }
     * 
     */
    public TLokacija createTLokacija() {
        return new TLokacija();
    }

    /**
     * Create an instance of {@link TPodnosilac }
     * 
     */
    public TPodnosilac createTPodnosilac() {
        return new TPodnosilac();
    }

    /**
     * Create an instance of {@link Tacka }
     * 
     */
    public Tacka createTacka() {
        return new Tacka();
    }

    /**
     * Create an instance of {@link Adresa.Grad }
     * 
     */
    public Adresa.Grad createAdresaGrad() {
        return new Adresa.Grad();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     * 
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Adresa.Broj }
     * 
     */
    public Adresa.Broj createAdresaBroj() {
        return new Adresa.Broj();
    }

    /**
     * Create an instance of {@link TPrimaoc }
     * 
     */
    public TPrimaoc createTPrimaoc() {
        return new TPrimaoc();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link TOsoba.Ime }
     * 
     */
    public TOsoba.Ime createTOsobaIme() {
        return new TOsoba.Ime();
    }

    /**
     * Create an instance of {@link TOsoba.Prezime }
     * 
     */
    public TOsoba.Prezime createTOsobaPrezime() {
        return new TOsoba.Prezime();
    }

    /**
     * Create an instance of {@link TtrazilacInformacije.DrugiPodaciZaKontakt }
     * 
     */
    public TtrazilacInformacije.DrugiPodaciZaKontakt createTtrazilacInformacijeDrugiPodaciZaKontakt() {
        return new TtrazilacInformacije.DrugiPodaciZaKontakt();
    }

    /**
     * Create an instance of {@link TdatumVreme.Vreme }
     * 
     */
    public TdatumVreme.Vreme createTdatumVremeVreme() {
        return new TdatumVreme.Vreme();
    }

    /**
     * Create an instance of {@link TdatumVreme.Datum }
     * 
     */
    public TdatumVreme.Datum createTdatumVremeDatum() {
        return new TdatumVreme.Datum();
    }

    /**
     * Create an instance of {@link TPravnoLice.Naziv }
     * 
     */
    public TPravnoLice.Naziv createTPravnoLiceNaziv() {
        return new TPravnoLice.Naziv();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju.UkupniTroskovi }
     * 
     */
    public Obavestenje.PodaciOPlacanju.UkupniTroskovi createObavestenjePodaciOPlacanjuUkupniTroskovi() {
        return new Obavestenje.PodaciOPlacanju.UkupniTroskovi();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju.BrojRacuna }
     * 
     */
    public Obavestenje.PodaciOPlacanju.BrojRacuna createObavestenjePodaciOPlacanjuBrojRacuna() {
        return new Obavestenje.PodaciOPlacanju.BrojRacuna();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju.PozivNaBroj }
     * 
     */
    public Obavestenje.PodaciOPlacanju.PozivNaBroj createObavestenjePodaciOPlacanjuPozivNaBroj() {
        return new Obavestenje.PodaciOPlacanju.PozivNaBroj();
    }

    /**
     * Create an instance of {@link Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak }
     * 
     */
    public Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak createObavestenjePodaciOPlacanjuPojedinacniTroskoviTrosak() {
        return new Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak();
    }

    /**
     * Create an instance of {@link Obavestenje.Odgovor.GodinaZahteva }
     * 
     */
    public Obavestenje.Odgovor.GodinaZahteva createObavestenjeOdgovorGodinaZahteva() {
        return new Obavestenje.Odgovor.GodinaZahteva();
    }

    /**
     * Create an instance of {@link Obavestenje.Odgovor.Datum }
     * 
     */
    public Obavestenje.Odgovor.Datum createObavestenjeOdgovorDatum() {
        return new Obavestenje.Odgovor.Datum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.Organ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Organ", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.Organ> createObavestenjeOrgan(Obavestenje.Organ value) {
        return new JAXBElement<Obavestenje.Organ>(_ObavestenjeOrgan_QNAME, Obavestenje.Organ.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Podnaslov", scope = Obavestenje.class)
    public JAXBElement<String> createObavestenjePodnaslov(String value) {
        return new JAXBElement<String>(_ObavestenjePodnaslov_QNAME, String.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.Dostavljeno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Dostavljeno", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.Dostavljeno> createObavestenjeDostavljeno(Obavestenje.Dostavljeno value) {
        return new JAXBElement<Obavestenje.Dostavljeno>(_ObavestenjeDostavljeno_QNAME, Obavestenje.Dostavljeno.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.Odgovor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Odgovor", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.Odgovor> createObavestenjeOdgovor(Obavestenje.Odgovor value) {
        return new JAXBElement<Obavestenje.Odgovor>(_ObavestenjeOdgovor_QNAME, Obavestenje.Odgovor.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.BrojPredmeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Broj_predmeta", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.BrojPredmeta> createObavestenjeBrojPredmeta(Obavestenje.BrojPredmeta value) {
        return new JAXBElement<Obavestenje.BrojPredmeta>(_ObavestenjeBrojPredmeta_QNAME, Obavestenje.BrojPredmeta.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Naslov", scope = Obavestenje.class)
    public JAXBElement<String> createObavestenjeNaslov(String value) {
        return new JAXBElement<String>(_ObavestenjeNaslov_QNAME, String.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.Datum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Datum", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.Datum> createObavestenjeDatum(Obavestenje.Datum value) {
        return new JAXBElement<Obavestenje.Datum>(_ObavestenjeDatum_QNAME, Obavestenje.Datum.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.PodaciOPlacanju }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Podaci_o_placanju", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.PodaciOPlacanju> createObavestenjePodaciOPlacanju(Obavestenje.PodaciOPlacanju value) {
        return new JAXBElement<Obavestenje.PodaciOPlacanju>(_ObavestenjePodaciOPlacanju_QNAME, Obavestenje.PodaciOPlacanju.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.Podnosilac }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Podnosilac", scope = Obavestenje.class)
    public JAXBElement<Obavestenje.Podnosilac> createObavestenjePodnosilac(Obavestenje.Podnosilac value) {
        return new JAXBElement<Obavestenje.Podnosilac>(_ObavestenjePodnosilac_QNAME, Obavestenje.Podnosilac.class, Obavestenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.obavestenje.com", name = "Broj_kancelarije", scope = TLokacija.class)
    public JAXBElement<Object> createTLokacijaBrojKancelarije(Object value) {
        return new JAXBElement<Object>(_TLokacijaBrojKancelarije_QNAME, Object.class, TLokacija.class, value);
    }

}