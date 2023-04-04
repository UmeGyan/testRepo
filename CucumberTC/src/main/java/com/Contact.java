package com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Contact {

    private static final int NUM_OF_LINES = 5;
    private static final String FILE_PATH = "src/test/java/resources/example.csv";
    private static final String FIELD_SEPARATOR = "|";
   
    public  void csvWrite() throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        Random random = new Random();

        // header line
        writer.write("id" + FIELD_SEPARATOR + "firstName" + FIELD_SEPARATOR + "lastName" + FIELD_SEPARATOR + "email" + FIELD_SEPARATOR + "companyId\n");

        // data lines
        for (int i = 1; i <= NUM_OF_LINES; i++) {
            int id = i;
            String firstName = generateRandomString(10);
            String lastName = generateRandomString(10);
            String email = generateRandomEmail();
            int companyId = random.nextInt(100) + 1;
            writer.write(id + FIELD_SEPARATOR + firstName + FIELD_SEPARATOR + lastName + FIELD_SEPARATOR + email + FIELD_SEPARATOR + companyId + "\n");
        }
       writer.close();
    }

    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    private static String generateRandomEmail() {
        String username = generateRandomString(8);
        String domain = generateRandomString(8) + ".com";
        return username + "@" + domain;
    }
}
