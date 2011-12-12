/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppc.soap.service.params;

import com.ppc.soap.service.params.utils.SynapticaUtils;
import java.util.Date;
import org.w3c.dom.Document;

/**
 *
 * @author Administrator
 */
public class ExportVocabularyParam {

    private String extractType;
    private Date incrementalDateTime;
    private String headwordVocabularies;
    private String relatedTermVocabularies;
    private String approvalStatus;
    private String activeStatus;

    /**
     * 
     * @param extractType
     * @param incrementalDateTime
     * @param headwordVocabularies
     * @param relatedTermVocabularies
     * @param approvalStatus
     * @param activeStatus
     */
    public ExportVocabularyParam(String extractType, Date incrementalDateTime, String headwordVocabularies, String relatedTermVocabularies, String approvalStatus, String activeStatus) {
        this.extractType = extractType;
        this.incrementalDateTime = incrementalDateTime;
        this.headwordVocabularies = headwordVocabularies;
        this.relatedTermVocabularies = relatedTermVocabularies;
        this.approvalStatus = approvalStatus;
        this.activeStatus = activeStatus;
    }

    /**
     * 
     * @return
     */
    public String toXML() {
        if(this.incrementalDateTime == null)
        {
            this.incrementalDateTime = new Date();
        }
        StringBuilder authXml = new StringBuilder("<XMLRequest>");
        authXml.append("<ExtractType>").append(this.extractType).append("</ExtractType>");
        authXml.append("<IncrementalDateTime>").append(SynapticaUtils.dateFormat(this.incrementalDateTime)).append("</IncrementalDateTime>");
        authXml.append("<HeadwordVocabularies><VocabularyID>").append(this.headwordVocabularies).append("</VocabularyID></HeadwordVocabularies>");
        authXml.append("<RelatedTermVocabularies><VocabularyID>").append(this.relatedTermVocabularies).append("</VocabularyID></RelatedTermVocabularies>");
        authXml.append("<ApprovalStatuses><ApprovalStatus>").append(this.approvalStatus).append("</ApprovalStatus></ApprovalStatuses>");
        authXml.append("<ActiveStatuses><ActiveStatus>").append(this.activeStatus).append("</ActiveStatus></ActiveStatuses>");
        authXml.append("</XMLRequest>");
        return authXml.toString();
    }

     /**
     * 
     * @return
     */
    public Document toDocument(){
        return SynapticaUtils.stringToNode(toXML());
    }
    
    
    /**
     * 
     * @return
     */
    public String getActiveStatus() {
        return activeStatus;
    }

    /**
     * 
     * @return
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 
     * @return
     */
    public String getExtractType() {
        return extractType;
    }

    /**
     * 
     * @return
     */
    public String getHeadwordVocabularies() {
        return headwordVocabularies;
    }

    /**
     * 
     * @return
     */
    public Date getIncrementalDateTime() {
        return incrementalDateTime;
    }

    /**
     * 
     * @return
     */
    public String getRelatedTermVocabularies() {
        return relatedTermVocabularies;
    }
}
