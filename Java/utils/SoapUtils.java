package utils;

import java.net.URL;

public class SoapUtils {

    public static void main(String[] args) {
        String[] apps = {"APNS_CHASE", "APNS_JPM", "PNS_CHASE", "PNS_JPM"};
        String[] tokens = {"2134213","3241234","asfdjhsdkjfl234", "sjadfh23sdfaf"};

        String url = "";
        for(int i = 1; i <= 4; i++) {
            url = "https://pnswebservice/qa0"+i+"/APNSService/09302012";
            SoapUtils.callPNSService(url, apps, tokens);
        }
    }

    public static void callPNSService(String url, String[] apps, String[] tokens) {
        String request = "";
        for(int i = 0; i < apps.length; i++) {
            request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://www.YourUrlAsPerWsdl.com/\">\r\n" +
                    "   <soapenv:Header/>\r\n" +
                    "   <soapenv:Body>\r\n" +
                    "      <ws:callRest>\r\n" +
                    "         <name>"+"Hello"+"</name>\r\n" +
                    "         <token>"+tokens[i]+"</token>\r\n" +
                    "         <appId>"+apps[i]+"</appId>\r\n" +
                    "      </ws:callRest>\r\n" +
                    "   </soapenv:Body>\r\n" +
                    "</soapenv:Envelope>";
//            URL obj = new URL(url);

        }
    }
}
