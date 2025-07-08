package com.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// CXF JAX-RS client Invoking GET Method

public class GetStudentClient {

  public static void main(String[] args) {
    try {
      URL url = new URL("http://localhost:8080/rest/rest/getName");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-Type", "application/json");
      Scanner scanner;
      String response;
      if (conn.getResponseCode() != 200) {
        scanner = new Scanner(conn.getErrorStream());
        response = "Error From Server \n\n";
      } else {
        scanner = new Scanner(conn.getInputStream());
        response = "Response From Server \n\n";
      }
      scanner.useDelimiter("\\Z");
      System.out.println(response + scanner.next());
      scanner.close();
      conn.disconnect();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}