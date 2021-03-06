package tim21.PortalVlasti.util.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XSDConstants {
    public static final String USER = "User";

    public static final String INFORMATION = "ObavestenjeRoot";

    public static final String REQUEST = "ZahtevRoot";

    public static final String REPORT = "IzvestajRoot";

    public static final String RESCRIPT = "ResenjeRoot";

    public static final String APPEAL_ANNOUNCEMENT = "ObavestenjeZalba";

    public static final Map<String, String> xsdPathMap;
    static {
        Map<String, String> map = new HashMap<>();
        map.put(USER, "classpath:xsd/user.xsd");
        map.put(INFORMATION, "classpath:xsd/Obavestenje.xsd");
        map.put(REQUEST, "classpath:xsd/zahtev.xsd");
        map.put(RESCRIPT, "classpath:xsd/resenje.xsd");
        map.put(REPORT, "classpath:xsd/izvestaj.xsd");
        map.put(APPEAL_ANNOUNCEMENT, "classpath:xsd/ObavestenjeZalba.xsd");

        xsdPathMap = Collections.unmodifiableMap(map);
    }
}
