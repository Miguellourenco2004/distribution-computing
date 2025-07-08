
package default_package;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consulta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consulta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Medico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MoradaClinica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NomeClinica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sintomas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consulta", propOrder = {
    "data",
    "medico",
    "moradaClinica",
    "nomeClinica",
    "sintomas"
})
public class Consulta {

    @XmlElement(name = "Data")
    protected String data;
    @XmlElement(name = "Medico")
    protected String medico;
    @XmlElement(name = "MoradaClinica")
    protected String moradaClinica;
    @XmlElement(name = "NomeClinica")
    protected String nomeClinica;
    @XmlElement(name = "Sintomas")
    protected String sintomas;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Gets the value of the medico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedico() {
        return medico;
    }

    /**
     * Sets the value of the medico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedico(String value) {
        this.medico = value;
    }

    /**
     * Gets the value of the moradaClinica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoradaClinica() {
        return moradaClinica;
    }

    /**
     * Sets the value of the moradaClinica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoradaClinica(String value) {
        this.moradaClinica = value;
    }

    /**
     * Gets the value of the nomeClinica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeClinica() {
        return nomeClinica;
    }

    /**
     * Sets the value of the nomeClinica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeClinica(String value) {
        this.nomeClinica = value;
    }

    /**
     * Gets the value of the sintomas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSintomas() {
        return sintomas;
    }

    /**
     * Sets the value of the sintomas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSintomas(String value) {
        this.sintomas = value;
    }

}
