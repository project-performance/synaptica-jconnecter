
package com.factiva.synaptica;

import com.ppc.soap.service.params.utils.SynapticaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Node;


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
 *         &lt;element name="ExportVocabulary70Result" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "exportVocabulary70Result"
})
@XmlRootElement(name = "ExportVocabulary70Response")
public class ExportVocabulary70Response {

    /**
     * 
     */
    @XmlElement(name = "ExportVocabulary70Result")
    protected ExportVocabulary70Response.ExportVocabulary70Result exportVocabulary70Result;

    /**
     * Gets the value of the exportVocabulary70Result property.
     * 
     * @return
     *     possible object is
     *     {@link ExportVocabulary70Response.ExportVocabulary70Result }
     *     
     */
    public ExportVocabulary70Response.ExportVocabulary70Result getExportVocabulary70Result() {
        return exportVocabulary70Result;
    }

    /**
     * Sets the value of the exportVocabulary70Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportVocabulary70Response.ExportVocabulary70Result }
     *     
     */
    public void setExportVocabulary70Result(ExportVocabulary70Response.ExportVocabulary70Result value) {
        this.exportVocabulary70Result = value;
    }


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
     *         &lt;any/>
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
        "content"
    })
    public static class ExportVocabulary70Result {

        /**
         * 
         */
        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link String }
         * 
         * 
         * @return 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }
        
        /**
         * 
         * @return
         */
        public String toXML() {
            List<Object> listObject = getContent();
            String xmlString = "";
                        
            for (int i = 0; i < listObject.size(); i++) {
                Node node = (Node) listObject.get(i);
                xmlString = SynapticaUtils.xmlToString(node);                
            }
            return xmlString;
        }
        
        /**
         * 
         * @return
         */
        public HashMap<String,String> toNodeResultMap() {
            
            HashMap<String,String> valueMap = new HashMap<String,String>();
            
            List<Object> listObject = getContent();
            for (int i = 0; i < listObject.size(); i++) {
                Node node = (Node) listObject.get(i);
                valueMap.putAll(SynapticaUtils.toNodeResultMap(node));
            }
            return valueMap;
        }
        

    }

}
