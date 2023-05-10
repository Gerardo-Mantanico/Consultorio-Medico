package com.consultationapi.consultationapi.readFile;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
        public  Data read(){
            String fileName = "C:/Users/HP/Desktop/Json entrada.JSON";
            String jsonString = readFile(fileName);
            Gson gson = new Gson();
            Data data = gson.fromJson(jsonString, Data.class);
            return data;
        }

        private  String readFile(String fileName) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append('\n');
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }

