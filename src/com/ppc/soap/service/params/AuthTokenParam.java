/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppc.soap.service.params;

import com.ppc.soap.service.params.utils.SynapticaUtils;
import org.w3c.dom.Document;

/**
 *
 * @author Administrator
 */
public class AuthTokenParam {
    
    private String userID;
    private String passWord;
    private String sessionKey;

    /**
     * 
     * @param userID
     * @param passWord
     */
    public AuthTokenParam(String userID, String passWord) {
        this.userID = userID;
        this.passWord = passWord;
    }

    /**
     * 
     * @param sessionKey
     */
    public AuthTokenParam(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 
     * @param userID
     * @param passWord
     * @param sessionKey
     */
    public AuthTokenParam(String userID, String passWord, String sessionKey) {
        this.userID = userID;
        this.passWord = passWord;
        this.sessionKey = sessionKey;
    }

    /**
     * 
     * @return
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 
     * @return
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 
     * @return
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 
     * @return
     */
    public String toXML() {
        StringBuilder authXml = new StringBuilder("<Authentication>");           

        if (this.sessionKey != null && !"".equals(this.sessionKey)) {
            authXml.append("<SessionKey>").append(this.sessionKey).append("</SessionKey>");
        } else {
            authXml.append("<UserID>").append(this.userID).append("</UserID><Password>").append(this.passWord).append("</Password>");
        }

        authXml.append("</Authentication>");
        return authXml.toString();
    }
    
    /**
     * 
     * @return
     */
    public Document toDocument(){
        return SynapticaUtils.stringToNode(toXML());
    }
    

    
}
