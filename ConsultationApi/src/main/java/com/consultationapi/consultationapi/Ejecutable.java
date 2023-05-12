package com.consultationapi.consultationapi;


import com.consultationapi.consultationapi.data.CreateRequestExam.CreateEx;
import com.consultationapi.consultationapi.data.SolicitudesExamenesLab.Solicitud;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.CreateIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_lab.CreateIformationLab;
import com.consultationapi.consultationapi.data.consultation.CreateConsultation;
import com.consultationapi.consultationapi.data.consultation.Examenes.CreateExmenesConsulta;
import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.type_exam.CreateTypeExam;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.data.user.ReadUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.consultation.Consultation;
import com.consultationapi.consultationapi.model.model.*;
import com.consultationapi.consultationapi.model.patient.Exam;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;
import com.consultationapi.consultationapi.readFile.Data;
import com.consultationapi.consultationapi.readFile.ReadFile;
import com.consultationapi.consultationapi.state.State;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;

import static java.lang.String.valueOf;


public class Ejecutable {

    public static void main(String args[]) {

        String filePath = "C:/Users/HP/Desktop/el-arte-de-amar.pdf";

        try {
            // Crear un objeto File con la ruta del archivo PDF
            File file = new File(filePath);

            // Crear un flujo de entrada para leer el archivo PDF
            InputStream inputStream = new FileInputStream(file);

            // Leer el archivo PDF y realizar las operaciones necesarias
            // Por ejemplo, puedes procesar el contenido del PDF o guardarlo en una base de datos
            // Aquí, simplemente imprimiremos el nombre y tamaño del archivo
            System.out.println("Nombre del archivo: " + file.getName());
            System.out.println("Tamaño del archivo: " + file.length() + " bytes");
            System.out.println("RUTA "+filePath);

            // Cerrar el flujo de entrada
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
