package fr.esgi.projetannuelgui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpJsonUtils {
    
    public static String getStringFromrl(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection urlConnection = null;
        try {
            urlConnection = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            try {
                if ((inputLine = in.readLine()) == null) break;
                stringBuilder.append(inputLine);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    public static String stringOrNullFromDate(Integer date) {
        if(date == null) return "unset";

        return date.toString();
    }
}
