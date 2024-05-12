package com.razuahamed.springboot.project_management.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class PdfFileDownloadService {

    @Async
    public void load(String url) {
        try {
            URL pdfUrl = new URL(url);
            URLConnection urlConnection = pdfUrl.openConnection();
            System.out.println(urlConnection.getContentType());
            if (!urlConnection.getContentType().equalsIgnoreCase("application/pdf; charset=utf-8")) {
                System.out.println("URL does not point to a PDF file.");
                return;
            }

            // Read PDF content into a byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteArray = new byte[1024];
            int readLength;

            InputStream inputStream = pdfUrl.openStream();
            while ((readLength = inputStream.read(byteArray)) > 0) {
                byteArrayOutputStream.write(byteArray, 0, readLength);
            }

            // Convert byte array to PDF
            byte[] pdfContent = byteArrayOutputStream.toByteArray();

            // Close streams
            inputStream.close();
            byteArrayOutputStream.close();

            // Save PDF content to a file
            FileOutputStream outputStream = new FileOutputStream("C:\\Downloads\\output.pdf");
            outputStream.write(pdfContent);
            outputStream.close();

            System.out.println("PDF downloaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
