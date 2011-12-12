/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppc.soap.service.params.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrator
 */
public class SynapticaUtils {

    /**
     * 
     */
    public static final String SESSION_KEY = "SessionKey";

    /**
     * 
     * @param xmlString
     * @return
     */
    public static Document stringToNode(String xmlString) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            org.xml.sax.InputSource inStream = new org.xml.sax.InputSource();
            inStream.setCharacterStream(new java.io.StringReader(xmlString));

            doc = docBuilder.parse(inStream);
        } catch (SAXException ex) {
            // Logger.getLogger(SynapticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            // Logger.getLogger(SynapticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            // Logger.getLogger(SynapticaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;

    }

    /**
     * 
     * @param node
     */
    public static void readXMLNodes(Node node) {

        NodeList list = node.getChildNodes();

        System.out.println("=> " + list.getLength() + " results from SharePoint Online");

        //Displaying every result received from SharePoint, with its ID  

        for (int i = 0; i < list.getLength(); i++) {

            //Gets the attributes of the current row/element  

            Node childnode = (Node) list.item(i);

            if ("SessionKey".equals(childnode.getNodeName())) {
                //sessionKey = childnode.getTextContent();
                System.out.println("******** sessionKey: " + childnode.getTextContent() + " ********");
            }

            System.out.println("******** getNodeName: " + childnode.getNodeName() + " ********");
            System.out.println("******** getNodeValue: " + childnode.getTextContent() + " ********");

            if (childnode.hasChildNodes()) {
                System.out.println("******** has Child: " + childnode.getChildNodes().getLength() + " ********");
                for (int j = 0; j < childnode.getChildNodes().getLength(); j++) {
                    Node grandChildnode = (Node) childnode.getChildNodes().item(j);
                    readXMLNodes(grandChildnode);
                    System.out.println("Task Name ::" + node.getChildNodes().getLength());
                }

            }
        }

    }

    /**
     * 
     * @param node
     * @return
     */
    public static HashMap<String, String> toNodeResultMap(Node node) {

        HashMap<String, String> valueMap = new HashMap<String, String>();
        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {

            Node childnode = (Node) list.item(i);
            valueMap.put(childnode.getNodeName(), childnode.getTextContent());

            if (childnode.hasChildNodes()) {

                for (int j = 0; j < childnode.getChildNodes().getLength(); j++) {
                    Node grandChildnode = (Node) childnode.getChildNodes().item(j);
                    valueMap.putAll(toNodeResultMap(grandChildnode));
                }
            }
        }

        return valueMap;
    }
    
   

    /**
     * Creates a string from an XML file with start and end indicators
     * @param docToString document to convert
     * @return string of the xml document
     */
    public static String xmlToString(Node docToString) {
        String returnString = "\n-------------- XML START --------------\n";
        try {
            //create string from xml tree
            //Output the XML
            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans;
            trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult streamResult = new StreamResult(sw);
            DOMSource source = new DOMSource(docToString);
            trans.transform(source, streamResult);
            String xmlString = sw.toString();
            //print the XML
            returnString = returnString + xmlString;
        } catch (TransformerException ex) {
            //  Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        returnString = returnString + "\n-------------- XML END --------------\n";
        return returnString;
    }

    /**
     * 
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {

        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss ");
        return format.format(date);
    }
}
