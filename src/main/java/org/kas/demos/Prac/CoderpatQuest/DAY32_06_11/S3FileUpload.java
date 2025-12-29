package org.kas.demos.Prac.CoderpatQuest.DAY32_06_11;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.File;

public class S3FileUpload {

    public static void main(String[] args) {
        String bucketName = "your-s3-bucket-name"; // Replace with your bucket name
        String keyName = "path/to/your/file.txt"; // The desired key (object name) in S3
        String filePath = "/local/path/to/your/file.txt"; // Local path to the file you want to upload

        // Create an S3Client instance
        S3Client s3Client = S3Client.builder()
                .build();

        try {
            // Build the PutObjectRequest
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();

            // Upload the file
            s3Client.putObject(putObjectRequest, RequestBody.fromFile(new File(filePath)));

            System.out.println("File uploaded successfully to S3: " + bucketName + "/" + keyName);

        } catch (Exception e) {
            System.err.println("Error uploading file to S3: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the S3Client
            s3Client.close();
        }
    }
}