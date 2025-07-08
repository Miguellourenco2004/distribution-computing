
package default_package;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the default_package package. 
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

    private final static QName _AddIntegers_QNAME = new QName("http://default_package/", "addIntegers");
    private final static QName _AddIntegersResponse_QNAME = new QName("http://default_package/", "addIntegersResponse");
    private final static QName _Factorial_QNAME = new QName("http://default_package/", "factorial");
    private final static QName _FactorialResponse_QNAME = new QName("http://default_package/", "factorialResponse");
    private final static QName _QueryDatabase_QNAME = new QName("http://default_package/", "queryDatabase");
    private final static QName _QueryDatabaseResponse_QNAME = new QName("http://default_package/", "queryDatabaseResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: default_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddIntegers }
     * 
     */
    public AddIntegers createAddIntegers() {
        return new AddIntegers();
    }

    /**
     * Create an instance of {@link AddIntegersResponse }
     * 
     */
    public AddIntegersResponse createAddIntegersResponse() {
        return new AddIntegersResponse();
    }

    /**
     * Create an instance of {@link Factorial }
     * 
     */
    public Factorial createFactorial() {
        return new Factorial();
    }

    /**
     * Create an instance of {@link FactorialResponse }
     * 
     */
    public FactorialResponse createFactorialResponse() {
        return new FactorialResponse();
    }

    /**
     * Create an instance of {@link QueryDatabase }
     * 
     */
    public QueryDatabase createQueryDatabase() {
        return new QueryDatabase();
    }

    /**
     * Create an instance of {@link QueryDatabaseResponse }
     * 
     */
    public QueryDatabaseResponse createQueryDatabaseResponse() {
        return new QueryDatabaseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIntegers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddIntegers }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "addIntegers")
    public JAXBElement<AddIntegers> createAddIntegers(AddIntegers value) {
        return new JAXBElement<AddIntegers>(_AddIntegers_QNAME, AddIntegers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIntegersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddIntegersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "addIntegersResponse")
    public JAXBElement<AddIntegersResponse> createAddIntegersResponse(AddIntegersResponse value) {
        return new JAXBElement<AddIntegersResponse>(_AddIntegersResponse_QNAME, AddIntegersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Factorial }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Factorial }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "factorial")
    public JAXBElement<Factorial> createFactorial(Factorial value) {
        return new JAXBElement<Factorial>(_Factorial_QNAME, Factorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FactorialResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FactorialResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "factorialResponse")
    public JAXBElement<FactorialResponse> createFactorialResponse(FactorialResponse value) {
        return new JAXBElement<FactorialResponse>(_FactorialResponse_QNAME, FactorialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryDatabase }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryDatabase }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "queryDatabase")
    public JAXBElement<QueryDatabase> createQueryDatabase(QueryDatabase value) {
        return new JAXBElement<QueryDatabase>(_QueryDatabase_QNAME, QueryDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryDatabaseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryDatabaseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "queryDatabaseResponse")
    public JAXBElement<QueryDatabaseResponse> createQueryDatabaseResponse(QueryDatabaseResponse value) {
        return new JAXBElement<QueryDatabaseResponse>(_QueryDatabaseResponse_QNAME, QueryDatabaseResponse.class, null, value);
    }

}
