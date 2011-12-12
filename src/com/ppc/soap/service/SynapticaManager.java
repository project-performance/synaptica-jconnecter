package com.ppc.soap.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.factiva.synaptica.ExportVocabulary70Response.ExportVocabulary70Result;
import com.factiva.synaptica.ExportVocabulary70;
import com.factiva.synaptica.ExportVocabularyResponse.ExportVocabularyResult;
import com.factiva.synaptica.GetSavedReport70Response.GetSavedReport70Result;
import com.factiva.synaptica.ImportTerms70Response.ImportTerms70Result;
import com.factiva.synaptica.ImportTerms71Response.ImportTerms71Result;
import com.factiva.synaptica.ImportTermsResponse.ImportTermsResult;
import com.factiva.synaptica.ListRelatedTerms70Response.ListRelatedTerms70Result;
import com.factiva.synaptica.ListRelatedTermsResponse.ListRelatedTermsResult;
import com.factiva.synaptica.ListTaskViews70;
import com.factiva.synaptica.ListTaskViews70Response.ListTaskViews70Result;
import com.factiva.synaptica.ListTaskViewsResponse.ListTaskViewsResult;
import com.factiva.synaptica.ListVocabularies70Response.ListVocabularies70Result;
import com.factiva.synaptica.ListVocabulariesResponse.ListVocabulariesResult;
import com.factiva.synaptica.LoginResponse.LoginResult;
import com.factiva.synaptica.LogoutResponse.LogoutResult;
import com.factiva.synaptica.SearchTerms70Response.SearchTerms70Result;
import com.factiva.synaptica.Service;
import com.factiva.synaptica.UpdateNumericExtendedAttribute72Response.UpdateNumericExtendedAttribute72Result;
import com.factiva.synaptica.ValidateTerms70Response.ValidateTerms70Result;
import com.factiva.synaptica.ValidateTermsResponse.ValidateTermsResult;
import com.ppc.soap.service.params.AuthTokenParam;
import com.ppc.soap.service.params.ExportVocabularyParam;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class SynapticaManager {

    /**
     * 
     */
    public Service synapticaService;
    private String wsdlPath;
    private String sessionKey;
    private String userID;
    private String password;
    private AuthTokenParam authTokenParam;   
    private ExportVocabularyParam exportVocabularyParam;

    /**
     * 
     * @param wsdlPath
     */
    public SynapticaManager(String wsdlPath) {
        this.wsdlPath = wsdlPath;
        synapticaService = new Service(wsdlPath);
    }

    /**
     * 
     * @param wsdlPath
     * @param userID
     * @param password
     */
    public SynapticaManager(String wsdlPath, String userID, String password) {
        this.wsdlPath = wsdlPath;
        this.userID = userID;
        this.password = password;
    }

    
    

    /**
     * 
     * @param userID
     * @param password
     * @return
     */
    public LoginResult loginToSynaptica(java.lang.String userID, java.lang.String password) {
        LoginResult loginResult = login(userID, password);
        this.userID = userID;
        this.password = password;
        sessionKey = loginResult.getSessionKey();
        authTokenParam = new AuthTokenParam(loginResult.getSessionKey());
        return loginResult;
    }

    /**
     * 
     * @param userID
     * @param password
     * @param sessionKey
     * @return
     */
    public LogoutResult logoutFromSynaptica(java.lang.String userID, java.lang.String password, java.lang.String sessionKey) {
        ListTaskViews70.ControlData controlDATA = new ListTaskViews70.ControlData();
        controlDATA.loadControlData(authTokenParam.toXML());
        return logout(userID, password, sessionKey);
    }

    /**
     * 
     * @return
     */
    public ListTaskViews70Result listSynapticaTaskViews70() {

        ListTaskViews70.ControlData controlDATA = new ListTaskViews70.ControlData();        
        controlDATA.loadControlData(authTokenParam.toXML());
        return listTaskViews70(controlDATA);
    }

    public ExportVocabulary70Result exportSynapticaVocabulary70() {
        ExportVocabulary70.ControlData controlDATA = new ExportVocabulary70.ControlData();
        controlDATA.loadControlData(authTokenParam.toXML());
        
        ExportVocabulary70.ReportParameters reportParameter = new ExportVocabulary70.ReportParameters();
        exportVocabularyParam = new ExportVocabularyParam("full",new Date(),"1000","all","all","1");
        reportParameter.loadControlData(exportVocabularyParam.toXML());
        
     return exportVocabulary70(controlDATA, reportParameter);    
    }
    
    /**
     * 
     * @param controlData
     * @param reportParameters
     * @return
     */
    private ExportVocabularyResult exportVocabulary(java.lang.String controlData, java.lang.String reportParameters) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.exportVocabulary(controlData, reportParameters);
    }

    /**
     * 
     * @param controlData
     * @param reportParameters
     * @return
     */
    private ExportVocabulary70Result exportVocabulary70(com.factiva.synaptica.ExportVocabulary70.ControlData controlData, com.factiva.synaptica.ExportVocabulary70.ReportParameters reportParameters) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.exportVocabulary70(controlData, reportParameters);
    }

    /**
     * 
     * @param controlData
     * @param fileRequested
     * @return
     */
    private GetSavedReport70Result getSavedReport70(com.factiva.synaptica.GetSavedReport70.ControlData controlData, java.lang.String fileRequested) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.getSavedReport70(controlData, fileRequested);
    }

    /**
     * 
     * @param controlData
     * @param tvpid
     * @param importXML
     * @return
     */
    private ImportTermsResult importTerms(java.lang.String controlData, java.lang.String tvpid, java.lang.String importXML) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.importTerms(controlData, tvpid, importXML);
    }

    /**
     * 
     * @param controlData
     * @param tvpid
     * @param importXML
     * @return
     */
    private ImportTerms70Result importTerms70(com.factiva.synaptica.ImportTerms70.ControlData controlData, java.lang.String tvpid, com.factiva.synaptica.ImportTerms70.ImportXML importXML) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.importTerms70(controlData, tvpid, importXML);
    }

    /**
     * 
     * @param controlData
     * @param tvpid
     * @param appendOrReplaceCategories
     * @param appendOrReplaceRelationships
     * @param importXML
     * @return
     */
    private ImportTerms71Result importTerms71(com.factiva.synaptica.ImportTerms71.ControlData controlData, java.lang.String tvpid, java.lang.String appendOrReplaceCategories, java.lang.String appendOrReplaceRelationships, com.factiva.synaptica.ImportTerms71.ImportXML importXML) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.importTerms71(controlData, tvpid, appendOrReplaceCategories, appendOrReplaceRelationships, importXML);
    }

    /**
     * 
     * @param controlData
     * @param term
     * @return
     */
    private ListRelatedTermsResult listRelatedTerms(java.lang.String controlData, java.lang.String term) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listRelatedTerms(controlData, term);
    }

    /**
     * 
     * @param controlData
     * @param term
     * @return
     */
    private ListRelatedTerms70Result listRelatedTerms70(com.factiva.synaptica.ListRelatedTerms70.ControlData controlData, com.factiva.synaptica.ListRelatedTerms70.Term term) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listRelatedTerms70(controlData, term);
    }

    /**
     * 
     * @param controlData
     * @return
     */
    private ListTaskViewsResult listTaskViews(java.lang.String controlData) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listTaskViews(controlData);
    }

    /**
     * 
     * @param controlData
     * @return
     */
    private ListTaskViews70Result listTaskViews70(com.factiva.synaptica.ListTaskViews70.ControlData controlData) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listTaskViews70(controlData);
    }

    /**
     * 
     * @param controlData
     * @param tvpid
     * @return
     */
    private ListVocabulariesResult listVocabularies(java.lang.String controlData, java.lang.String tvpid) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listVocabularies(controlData, tvpid);
    }

    /**
     * 
     * @param controlData
     * @param tvpid
     * @return
     */
    private ListVocabularies70Result listVocabularies70(com.factiva.synaptica.ListVocabularies70.ControlData controlData, java.lang.String tvpid) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.listVocabularies70(controlData, tvpid);
    }

    /**
     * 
     * @param userID
     * @param password
     * @return
     */
    private LoginResult login(java.lang.String userID, java.lang.String password) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.login(userID, password);
    }

    /**
     * 
     * @param userID
     * @param password
     * @param sessionKey
     * @return
     */
    private LogoutResult logout(java.lang.String userID, java.lang.String password, java.lang.String sessionKey) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.logout(userID, password, sessionKey);
    }

    /**
     * 
     * @param controlData
     * @param searchParameters
     * @return
     */
    private SearchTerms70Result searchTerms70(com.factiva.synaptica.SearchTerms70.ControlData controlData, com.factiva.synaptica.SearchTerms70.SearchParameters searchParameters) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.searchTerms70(controlData, searchParameters);
    }

    /**
     * 
     * @param controlData
     * @param updateParameters
     * @return
     */
    private UpdateNumericExtendedAttribute72Result updateNumericExtendedAttribute72(com.factiva.synaptica.UpdateNumericExtendedAttribute72.ControlData controlData, com.factiva.synaptica.UpdateNumericExtendedAttribute72.UpdateParameters updateParameters) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.updateNumericExtendedAttribute72(controlData, updateParameters);
    }

    /**
     * 
     * @param controlData
     * @param terms
     * @return
     */
    private ValidateTermsResult validateTerms(java.lang.String controlData, java.lang.String terms) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.validateTerms(controlData, terms);
    }

    /**
     * 
     * @param controlData
     * @param terms
     * @return
     */
    private ValidateTerms70Result validateTerms70(com.factiva.synaptica.ValidateTerms70.ControlData controlData, com.factiva.synaptica.ValidateTerms70.Terms terms) {
        com.factiva.synaptica.ServiceSoap port = synapticaService.getServiceSoap();
        return port.validateTerms70(controlData, terms);
    }
}
