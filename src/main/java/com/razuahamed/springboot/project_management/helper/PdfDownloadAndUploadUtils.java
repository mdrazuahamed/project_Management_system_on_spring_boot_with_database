package com.razuahamed.springboot.project_management.helper;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;


public class PdfDownloadAndUploadUtils {
    public void uploadToS3(byte[] data) {
        String folderName = "12"; // Specify the folder name
        String fileName = generateFileName();
        String path = folderName + "/" + fileName; // Combine folder name and file name as the key
        try {
            String accessKey = System.getenv("AWS_ACCESS_KEY");
            String secretKey = System.getenv("AWS_SECRET_KEY");
            String bucketName = System.getenv("AWS_ACCESS_KEY");
            String awsRegion = System.getenv("AWS_SECRET_KEY");

            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(awsRegion)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .build();

            InputStream inputStream = new ByteArrayInputStream(data);

            s3Client.putObject(new PutObjectRequest(bucketName, path, inputStream, null));

            System.out.println("File uploaded to S3: " + path);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    private String generateFileName() {
        return UUID.randomUUID().toString() + ".pdf";
    }
}
