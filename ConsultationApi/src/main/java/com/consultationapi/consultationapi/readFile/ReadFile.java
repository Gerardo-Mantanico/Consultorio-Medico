package com.consultationapi.consultationapi.readFile;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
        public static void main(String[] args) {
            String fileName = "datos.json";
            String jsonString = readFile(fileName);
            Gson gson = new Gson();
           // Data data = gson.fromJson(jsonString, Data.class);
        }

        private static String readFile(String fileName) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }

}
