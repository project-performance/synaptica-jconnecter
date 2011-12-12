
package com.factiva.synaptica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ControlData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tvpid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "controlData",
    "tvpid"
})
@XmlRootElement(name = "ListVocabularies")
public class ListVocabularies {

    /**
     * 
     */
    @XmlElement(name = "ControlData")
    protected String controlData;
    /**
     * 
     */
    protected String tvpid;

    /**
     * Gets the value of the controlData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlData() {
        return controlData;
    }

    /**
     * Sets the value of the controlData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlData(String value) {
        this.controlData = value;
    }

    /**
     * Gets the value of the tvpid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTvpid() {
        return tvpid;
    }

    /**
     * Sets the value of the tvpid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTvpid(String value) {
        this.tvpid = value;
    }

}
