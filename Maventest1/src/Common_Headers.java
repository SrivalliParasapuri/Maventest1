import java.util.HashMap;
import java.util.Map;

public class Common_Headers {
    public static Map<String, String> CommonHeaders(){
        Map<String, String> Commonheaders = new HashMap<>();
        Commonheaders.put("Accept","application/json");Commonheaders.put("countryCode","US");
        Commonheaders.put("source","web");
        Commonheaders.put("languagecode","en");Commonheaders.put("Content-Type","application/json");
        Commonheaders.put("correlationID","cas-uuid-NB6PXdHUfGKS2kmZTpBOj");
        Commonheaders.put("X-Yard","12");Commonheaders.put("AUTHORIZATIONROLE","US_General_Manager");
        return Commonheaders;
    }
    public static Map<String, String> SOHeaders(){
        Map<String, String> SOheaders = new HashMap<>();
        SOheaders.put("Accept","application/json, text/plain, */*");SOheaders.put("countryCode","US");
        SOheaders.put("source","web");SOheaders.put("Authorization","bearer");
        SOheaders.put("languagecode","en");SOheaders.put("Content-Type","application/json");
        SOheaders.put("correlationID","cas-uuid-NB6PXdHUfGKS2kmZTpBOj");
        SOheaders.put("X-Yard","12");SOheaders.put("AUTHORIZATIONROLE","US_General_Manager");
        SOheaders.put("Connection","keep-alive");
        return SOHeaders();

    }
    public static Map<String, String> TokenHeaders(){
        Map<String, String> Tokenheaders = new HashMap<>();
        Tokenheaders.put("Accept","application/json, text/plain, */*");Tokenheaders.put("countryCode","US");
        Tokenheaders.put("source","web");Tokenheaders.put("Authorization","bearer");
        Tokenheaders.put("languagecode","en");Tokenheaders.put("Content-Type","application/json");
        Tokenheaders.put("correlationID","cas-uuid-NB6PXdHUfGKS2kmZTpBOj");
        Tokenheaders.put("X-Yard","12");Tokenheaders.put("AUTHORIZATIONROLE","US_General_Manager");
        Tokenheaders.put("Connection","keep-alive");Tokenheaders.put("isLock","false");
        Tokenheaders.put("keepAlive","true");
        return TokenHeaders();
}
}
