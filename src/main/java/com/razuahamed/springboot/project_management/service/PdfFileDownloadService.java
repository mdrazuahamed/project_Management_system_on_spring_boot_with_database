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
            if (!urlConnection.getContentType().equalsIgnoreCase("application/pdf")) {
                System.out.println("URL does not point to a PDF file.");
                return;
            }

            FileOutputStream outputStream = new FileOutputStream("C:\\Downloads\\output.pdf");
            byte[] byteArray = new byte[1024];
            int readLength;

            InputStream inputStream = pdfUrl.openStream();
            while ((readLength = inputStream.read(byteArray)) > 0) {
                outputStream.write(byteArray, 0, readLength);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
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
