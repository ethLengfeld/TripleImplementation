package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class APIUtils {

    public static void main(String[] args) {
        System.out.print("Enter how many dog facts you are interested in: ");
        Scanner in = new Scanner(System.in);
        int numFacts = in.nextInt();

        String targetURL = args[1].replace("<num>", String.valueOf(numFacts));

        try {
            //Create connection
            URL url = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Get Response
            InputStream is = connection.getInputStream();
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (is, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            numFacts = 1;
            JSONArray jsonArray = new JSONArray(textBuilder.toString());
            for (Object currObj : jsonArray) {
                JSONObject currJson = (JSONObject) currObj;
                System.out.println("Fact " + numFacts++ + ": " + currJson.get("fact"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
