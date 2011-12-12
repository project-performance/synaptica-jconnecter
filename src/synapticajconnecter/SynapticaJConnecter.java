/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synapticajconnecter;

import com.factiva.synaptica.ExportVocabulary70Response.ExportVocabulary70Result;
import com.factiva.synaptica.ListTaskViews70Response.ListTaskViews70Result;
import com.factiva.synaptica.LoginResponse.LoginResult;
import com.factiva.synaptica.LogoutResponse.LogoutResult;
import com.ppc.soap.service.SynapticaManager;
import com.ppc.soap.service.params.AuthTokenParam;
import com.ppc.soap.service.params.utils.SynapticaUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author devarpi
 */
public class SynapticaJConnecter {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        // TODO code application logic here
        
        SynapticaManager synpaticaManager = new SynapticaManager("http://synaptica.net/ppcws/service.asmx?WSDL");
        LoginResult loginResult = synpaticaManager.loginToSynaptica("ipappas", "ppcws878");
        
        
        //ListTaskViews70Result result = listTaskViews70();
        System.out.println(loginResult.toXML());
        HashMap<String,String> returnVal = loginResult.toNodeResultMap();
        
        
        
         SynapticaUtils.dateFormat(new Date());
         AuthTokenParam authTokenParam = new AuthTokenParam(loginResult.getSessionKey());
         
         ListTaskViews70Result listTaskViews70Result = synpaticaManager.listSynapticaTaskViews70();
         
         System.out.println(listTaskViews70Result.toXML());
         
         
         ExportVocabulary70Result exportVocabulary70Result = synpaticaManager.exportSynapticaVocabulary70();
         System.out.println(exportVocabulary70Result.toXML());
           Iterator it = exportVocabulary70Result.toNodeResultMap().entrySet().iterator();     
         while (it.hasNext()) 
         {         
             Map.Entry pairs = (Map.Entry)it.next();         
             System.out.println(pairs.getKey() + " = " + pairs.getValue());                   
         }
         
         it.remove();
         LogoutResult logout = synpaticaManager.logoutFromSynaptica("ipappas", "ppcws878",loginResult.getSessionKey());
         
//         System.out.println(logout.toXML());
//        HashMap<String,String> returnVal1 =  logout.toNodeResultMap();
//        Iterator it1 = returnVal.entrySet().iterator();     
//         while (it1.hasNext()) 
//         {         Map.Entry pairs = (Map.Entry)it1.next();         
//                   System.out.println(pairs.getKey() + " = " + pairs.getValue());
//                   if("SessionKey".equals(pairs.getKey())) {
//                       SessionKey = (String) pairs.getValue();
//                   }
//         }
//         it1.remove();
    }
}
