package default_package;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.6.4
 * 2024-11-03T17:02:12.125Z
 * Generated source version: 3.6.4
 *
 */
@WebServiceClient(name = "MathUtilityService",
                  wsdlLocation = "http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl",
                  targetNamespace = "http://default_package/")
public class MathUtilityService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://default_package/", "MathUtilityService");
    public static final QName MathUtilityPort = new QName("http://default_package/", "MathUtilityPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MathUtilityService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MathUtilityService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MathUtilityService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MathUtilityService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public MathUtilityService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MathUtilityService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MathUtilityService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns MathUtility
     */
    @WebEndpoint(name = "MathUtilityPort")
    public MathUtility getMathUtilityPort() {
        return super.getPort(MathUtilityPort, MathUtility.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MathUtility
     */
    @WebEndpoint(name = "MathUtilityPort")
    public MathUtility getMathUtilityPort(WebServiceFeature... features) {
        return super.getPort(MathUtilityPort, MathUtility.class, features);
    }

}
