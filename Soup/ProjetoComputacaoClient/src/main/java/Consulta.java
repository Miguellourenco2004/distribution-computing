import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;  // Importe a interface Serializable

@XmlRootElement(name = "Consulta")
public class Consulta implements Serializable { // Implementando a interface Serializable

    private static final long serialVersionUID = 1L;  // A adição dessa constante é recomendada para a serialização

    private String medico;
    private String data;
    private String sintomas;
    private String nomeClinica;
    private String moradaClinica;

    // Construtor vazio é necessário para JAXB
    public Consulta() {
    }

    // Construtor com parâmetros
    public Consulta(String medico, String data, String sintomas, String nomeClinica, String moradaClinica) {
        this.medico = medico;
        this.data = data;
        this.sintomas = sintomas;
        this.nomeClinica = nomeClinica;
        this.moradaClinica = moradaClinica;
    }

    @XmlElement(name = "Medico")
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    @XmlElement(name = "Data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlElement(name = "Sintomas")
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @XmlElement(name = "NomeClinica")
    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    @XmlElement(name = "MoradaClinica")
    public String getMoradaClinica() {
        return moradaClinica;
    }

    public void setMoradaClinica(String moradaClinica) {
        this.moradaClinica = moradaClinica;
    }
}
