
package com.factiva.synaptica;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Service", targetNamespace = "http://synaptica.factiva.com/", wsdlLocation = "wsdl/synaptica.net/ppcws/service.asmx.wsdl")
public class Service
    extends javax.xml.ws.Service
{

    private final static URL SERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICE_EXCEPTION;
    private final static QName SERVICE_QNAME = new QName("http://synaptica.factiva.com/", "Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("wsdl/synaptica.net/ppcws/service.asmx.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICE_WSDL_LOCATION = url;
        SERVICE_EXCEPTION = e;
    }

    
    
    /**
     * 
     * @param wsdlLocation
     */
    public Service(String wsdlLocation) {
        super(getURL(wsdlLocation), SERVICE_QNAME);       
    }

    /**
     * 
     * @param features
     */
    public Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICE_QNAME, features);
    }

    /**
     * 
     * @param wsdlLocation
     */
    public Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE_QNAME);
    }

    /**
     * 
     * @param wsdlLocation
     * @param features
     */
    public Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE_QNAME, features);
    }

    /**
     * 
     * @param wsdlLocation
     * @param serviceName
     */
    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @param wsdlLocation
     * @param serviceName
     * @param features
     */
    public Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceSoap
     */
    @WebEndpoint(name = "ServiceSoap")
    public ServiceSoap getServiceSoap() {
        return super.getPort(new QName("http://synaptica.factiva.com/", "ServiceSoap"), ServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceSoap
     */
    @WebEndpoint(name = "ServiceSoap")
    public ServiceSoap getServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://synaptica.factiva.com/", "ServiceSoap"), ServiceSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns ServiceSoap
     */
    @WebEndpoint(name = "ServiceSoap12")
    public ServiceSoap getServiceSoap12() {
        return super.getPort(new QName("http://synaptica.factiva.com/", "ServiceSoap12"), ServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceSoap
     */
    @WebEndpoint(name = "ServiceSoap12")
    public ServiceSoap getServiceSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://synaptica.factiva.com/", "ServiceSoap12"), ServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICE_EXCEPTION!= null) {
            throw SERVICE_EXCEPTION;
        }
        return SERVICE_WSDL_LOCATION;
    }
    
    private static URL getURL(String wsdlLocation) {
         URL url = null;
        try {
            url = new URL(wsdlLocation);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return url;
    }

     

}
