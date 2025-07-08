
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

    private final static QName _Consulta_QNAME = new QName("http://default_package/", "Consulta");
	private final static QName _AddIntegers_QNAME = new QName("http://default_package/", "addIntegers");
    private final static QName _AddIntegersResponse_QNAME = new QName("http://default_package/", "addIntegersResponse");
    private final static QName _CancelarConsultaPorUsuario_QNAME = new QName("http://default_package/", "cancelarConsultaPorUsuario");
	private final static QName _CancelarConsultaPorUsuarioResponse_QNAME = new QName("http://default_package/", "cancelarConsultaPorUsuarioResponse");
	private final static QName _CriarPaciente_QNAME = new QName("http://default_package/", "criarPaciente");
	private final static QName _CriarPacienteResponse_QNAME = new QName("http://default_package/", "criarPacienteResponse");
	private final static QName _Factorial_QNAME = new QName("http://default_package/", "factorial");
    private final static QName _FactorialResponse_QNAME = new QName("http://default_package/", "factorialResponse");

    private final static QName _ListarClinicas_QNAME = new QName("http://default_package/", "listarClinicas");
	private final static QName _ListarClinicasResponse_QNAME = new QName("http://default_package/", "listarClinicasResponse");
	private final static QName _ListarConsultasPaciente_QNAME = new QName("http://default_package/", "listarConsultasPaciente");
	private final static QName _ListarConsultasPacienteResponse_QNAME = new QName("http://default_package/", "listarConsultasPacienteResponse");
	private final static QName _GetIdUsuario_QNAME = new QName("http://default_package/", "getIdUsuario");
	private final static QName _GetIdUsuarioResponse_QNAME = new QName("http://default_package/", "getIdUsuarioResponse");
	private final static QName _LoginUtilizador_QNAME = new QName("http://default_package/", "loginUtilizador");
	private final static QName _LoginUtilizadorResponse_QNAME = new QName("http://default_package/", "loginUtilizadorResponse");
	private final static QName _MarcarConsulta_QNAME = new QName("http://default_package/", "marcarConsulta");
	private final static QName _MarcarConsultaResponse_QNAME = new QName("http://default_package/", "marcarConsultaResponse");
	private final static QName _ObterIdUtilizador_QNAME = new QName("http://default_package/", "obterIdUtilizador");
	private final static QName _ObterIdUtilizadorResponse_QNAME = new QName("http://default_package/", "obterIdUtilizadorResponse");
	private final static QName _QueryAuthServerTest_QNAME = new QName("http://default_package/", "queryAuthServerTest");
	private final static QName _QueryAuthServerTestResponse_QNAME = new QName("http://default_package/", "queryAuthServerTestResponse");
	private final static QName _QueryDatabase_QNAME = new QName("http://default_package/", "queryDatabase");
	private final static QName _QueryDatabaseResponse_QNAME = new QName("http://default_package/", "queryDatabaseResponse");

	private final static QName _RegistarUtilizador_QNAME = new QName("http://default_package/", "registarUtilizador");
	private final static QName _RegistarUtilizadorResponse_QNAME = new QName("http://default_package/", "registarUtilizadorResponse");

	/**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: default_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Consulta }
     * 
     */
    public Consulta createConsulta() {
        return new Consulta();
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
     * Create an instance of {@link CancelarConsultaPorUsuario }
     * 
     */
    public CancelarConsultaPorUsuario createCancelarConsultaPorUsuario() {
        return new CancelarConsultaPorUsuario();
    }

	/**
     * Create an instance of {@link CancelarConsultaPorUsuarioResponse }
     * 
     */
    public CancelarConsultaPorUsuarioResponse createCancelarConsultaPorUsuarioResponse() {
        return new CancelarConsultaPorUsuarioResponse();
    }

	/**
     * Create an instance of {@link CriarPaciente }
     * 
     */
    public CriarPaciente createCriarPaciente() {
        return new CriarPaciente();
    }

	/**
     * Create an instance of {@link CriarPacienteResponse }
     * 
     */
    public CriarPacienteResponse createCriarPacienteResponse() {
        return new CriarPacienteResponse();
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
     * Create an instance of {@link ListarClinicas }
     * 
     */
    public ListarClinicas createListarClinicas() {
        return new ListarClinicas();
    }

	/**
     * Create an instance of {@link ListarClinicasResponse }
     * 
     */
    public ListarClinicasResponse createListarClinicasResponse() {
        return new ListarClinicasResponse();
    }

	/**
     * Create an instance of {@link ListarConsultasPaciente }
     * 
     */
    public ListarConsultasPaciente createListarConsultasPaciente() {
        return new ListarConsultasPaciente();
    }

	/**
     * Create an instance of {@link ListarConsultasPacienteResponse }
     * 
     */
    public ListarConsultasPacienteResponse createListarConsultasPacienteResponse() {
        return new ListarConsultasPacienteResponse();
    }

	/**
     * Create an instance of {@link GetIdUsuario }
     * 
     */


	/**
     * Create an instance of {@link GetIdUsuarioResponse }
     * 
     */
   

	/**
     * Create an instance of {@link LoginUtilizador }
     * 
     */
    public LoginUtilizador createLoginUtilizador() {
        return new LoginUtilizador();
    }

	/**
     * Create an instance of {@link LoginUtilizadorResponse }
     * 
     */
    public LoginUtilizadorResponse createLoginUtilizadorResponse() {
        return new LoginUtilizadorResponse();
    }

	/**
     * Create an instance of {@link MarcarConsulta }
     * 
     */
    public MarcarConsulta createMarcarConsulta() {
        return new MarcarConsulta();
    }

	/**
     * Create an instance of {@link MarcarConsultaResponse }
     * 
     */
    public MarcarConsultaResponse createMarcarConsultaResponse() {
        return new MarcarConsultaResponse();
    }

	/**
     * Create an instance of {@link ObterIdUtilizador }
     * 
     */
    public ObterIdUtilizador createObterIdUtilizador() {
        return new ObterIdUtilizador();
    }

	/**
     * Create an instance of {@link ObterIdUtilizadorResponse }
     * 
     */
    public ObterIdUtilizadorResponse createObterIdUtilizadorResponse() {
        return new ObterIdUtilizadorResponse();
    }

	/**
     * Create an instance of {@link QueryAuthServerTest }
     * 
     */
    public QueryAuthServerTest createQueryAuthServerTest() {
        return new QueryAuthServerTest();
    }

	/**
     * Create an instance of {@link QueryAuthServerTestResponse }
     * 
     */
    public QueryAuthServerTestResponse createQueryAuthServerTestResponse() {
        return new QueryAuthServerTestResponse();
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
     * Create an instance of {@link RegistarUtilizador }
     * 
     */
    public RegistarUtilizador createRegistarUtilizador() {
        return new RegistarUtilizador();
    }

	/**
     * Create an instance of {@link RegistarUtilizadorResponse }
     * 
     */
    public RegistarUtilizadorResponse createRegistarUtilizadorResponse() {
        return new RegistarUtilizadorResponse();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consulta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Consulta }{@code >}
     */
//    @XmlElementDecl(namespace = "http://default_package/", name = "Consulta")
    public JAXBElement<Consulta> createConsulta(Consulta value) {
        return new JAXBElement<Consulta>(_Consulta_QNAME, Consulta.class, null, value);
    }

	/**
     * Create an instance of {@link Timestamp }
     * 
     */
  

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
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarConsultaPorUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarConsultaPorUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarConsultaPorUsuario")
    public JAXBElement<CancelarConsultaPorUsuario> createCancelarConsultaPorUsuario(CancelarConsultaPorUsuario value) {
        return new JAXBElement<CancelarConsultaPorUsuario>(_CancelarConsultaPorUsuario_QNAME, CancelarConsultaPorUsuario.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarConsultaPorUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarConsultaPorUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarConsultaPorUsuarioResponse")
    public JAXBElement<CancelarConsultaPorUsuarioResponse> createCancelarConsultaPorUsuarioResponse(CancelarConsultaPorUsuarioResponse value) {
        return new JAXBElement<CancelarConsultaPorUsuarioResponse>(_CancelarConsultaPorUsuarioResponse_QNAME, CancelarConsultaPorUsuarioResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPaciente }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPaciente }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "criarPaciente")
    public JAXBElement<CriarPaciente> createCriarPaciente(CriarPaciente value) {
        return new JAXBElement<CriarPaciente>(_CriarPaciente_QNAME, CriarPaciente.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPacienteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPacienteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "criarPacienteResponse")
    public JAXBElement<CriarPacienteResponse> createCriarPacienteResponse(CriarPacienteResponse value) {
        return new JAXBElement<CriarPacienteResponse>(_CriarPacienteResponse_QNAME, CriarPacienteResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarClinicas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarClinicas }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarClinicas")
    public JAXBElement<ListarClinicas> createListarClinicas(ListarClinicas value) {
        return new JAXBElement<ListarClinicas>(_ListarClinicas_QNAME, ListarClinicas.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarClinicasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarClinicasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarClinicasResponse")
    public JAXBElement<ListarClinicasResponse> createListarClinicasResponse(ListarClinicasResponse value) {
        return new JAXBElement<ListarClinicasResponse>(_ListarClinicasResponse_QNAME, ListarClinicasResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarConsultasPaciente }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarConsultasPaciente }{@code >}
     */
//    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultasPaciente")
    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultasPaciente")
	public JAXBElement<ListarConsultasPaciente> createListarConsultasPaciente(ListarConsultasPaciente value) {
        return new JAXBElement<ListarConsultasPaciente>(_ListarConsultasPaciente_QNAME, ListarConsultasPaciente.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarConsultasPacienteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarConsultasPacienteResponse }{@code >}
     */
//    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultasPacienteResponse")
    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultasPacienteResponse")
	public JAXBElement<ListarConsultasPacienteResponse> createListarConsultasPacienteResponse(ListarConsultasPacienteResponse value) {
        return new JAXBElement<ListarConsultasPacienteResponse>(_ListarConsultasPacienteResponse_QNAME, ListarConsultasPacienteResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetIdUsuario }{@code >}
     */


	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetIdUsuarioResponse }{@code >}
     */


	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUtilizador }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUtilizador }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "loginUtilizador")
    public JAXBElement<LoginUtilizador> createLoginUtilizador(LoginUtilizador value) {
        return new JAXBElement<LoginUtilizador>(_LoginUtilizador_QNAME, LoginUtilizador.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUtilizadorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUtilizadorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "loginUtilizadorResponse")
    public JAXBElement<LoginUtilizadorResponse> createLoginUtilizadorResponse(LoginUtilizadorResponse value) {
        return new JAXBElement<LoginUtilizadorResponse>(_LoginUtilizadorResponse_QNAME, LoginUtilizadorResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarcarConsulta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarcarConsulta }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "marcarConsulta")
    public JAXBElement<MarcarConsulta> createMarcarConsulta(MarcarConsulta value) {
        return new JAXBElement<MarcarConsulta>(_MarcarConsulta_QNAME, MarcarConsulta.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarcarConsultaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarcarConsultaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "marcarConsultaResponse")
    public JAXBElement<MarcarConsultaResponse> createMarcarConsultaResponse(MarcarConsultaResponse value) {
        return new JAXBElement<MarcarConsultaResponse>(_MarcarConsultaResponse_QNAME, MarcarConsultaResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterIdUtilizador }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObterIdUtilizador }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "obterIdUtilizador")
    public JAXBElement<ObterIdUtilizador> createObterIdUtilizador(ObterIdUtilizador value) {
        return new JAXBElement<ObterIdUtilizador>(_ObterIdUtilizador_QNAME, ObterIdUtilizador.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterIdUtilizadorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObterIdUtilizadorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "obterIdUtilizadorResponse")
    public JAXBElement<ObterIdUtilizadorResponse> createObterIdUtilizadorResponse(ObterIdUtilizadorResponse value) {
        return new JAXBElement<ObterIdUtilizadorResponse>(_ObterIdUtilizadorResponse_QNAME, ObterIdUtilizadorResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAuthServerTest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryAuthServerTest }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "queryAuthServerTest")
    public JAXBElement<QueryAuthServerTest> createQueryAuthServerTest(QueryAuthServerTest value) {
        return new JAXBElement<QueryAuthServerTest>(_QueryAuthServerTest_QNAME, QueryAuthServerTest.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAuthServerTestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryAuthServerTestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "queryAuthServerTestResponse")
    public JAXBElement<QueryAuthServerTestResponse> createQueryAuthServerTestResponse(QueryAuthServerTestResponse value) {
        return new JAXBElement<QueryAuthServerTestResponse>(_QueryAuthServerTestResponse_QNAME, QueryAuthServerTestResponse.class, null, value);
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

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUtilizador }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUtilizador }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "registarUtilizador")
    public JAXBElement<RegistarUtilizador> createRegistarUtilizador(RegistarUtilizador value) {
        return new JAXBElement<RegistarUtilizador>(_RegistarUtilizador_QNAME, RegistarUtilizador.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUtilizadorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUtilizadorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "registarUtilizadorResponse")
    public JAXBElement<RegistarUtilizadorResponse> createRegistarUtilizadorResponse(RegistarUtilizadorResponse value) {
        return new JAXBElement<RegistarUtilizadorResponse>(_RegistarUtilizadorResponse_QNAME, RegistarUtilizadorResponse.class, null, value);
    }

}
