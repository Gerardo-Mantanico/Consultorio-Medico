package com.consultationapi.consultationapi.readFile;

import com.consultationapi.consultationapi.data.CreateRequestExam.CreateEx;
import com.consultationapi.consultationapi.data.SolicitudesExamenesLab.Solicitud;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.CreateIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_lab.CreateIformationLab;
import com.consultationapi.consultationapi.data.consultation.CreateConsultation;
import com.consultationapi.consultationapi.data.consultation.Examenes.CreateExmenesConsulta;
import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.type_exam.CreateTypeExam;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.consultation.Consultation;
import com.consultationapi.consultationapi.model.model.*;
import com.consultationapi.consultationapi.model.patient.Exam;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;
import com.consultationapi.consultationapi.resources.Encriptar;
import com.consultationapi.consultationapi.state.State;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Modelo {

    public void read(String path) throws NoSuchAlgorithmException {
        Encriptar encriptar = new Encriptar();
        ReadFile readFile = new ReadFile();
        Data data = readFile.read(path);

        CreateUser createUser = new CreateUser();
        for (Admin admin : data.getAdmin()) {
            User user = new User();
            user.setId(admin.getId());
            user.setName(admin.getNombre());
            user.setUserName(admin.getUsername());
            user.setPassword(encriptar.hashPassword(admin.getPassword()));
            user.setEmail(admin.getEmail());
            user.setDate(Date.valueOf(admin.getFecha_nacimiento()));
            user.setSaldo(BigDecimal.valueOf(admin.getSaldo()));
            user.setType(State.Administrador.name());
            createUser.createUser(user);
        }
        for (Especialidad especialidad : data.getEspecialidades()) {
            CreateSpecialty createSpecialty = new CreateSpecialty();
            createSpecialty.create(especialidad);

        }
        for (TipoExamen tipoExamen : data.getTipos_examenes()) {
            CreateTypeExam createTypeExam = new CreateTypeExam();
            createTypeExam.create(tipoExamen);
        }

        for (Medico medico : data.getMedicos()) {
            CreateUser createUser1 = new CreateUser();
            TypeUser typeUser = new TypeUser();
            typeUser.setId(medico.getId());
            typeUser.setName(medico.getNombre());
            typeUser.setUserName(medico.getUsername());
            typeUser.setPassword(encriptar.hashPassword(medico.getPassword()));
            typeUser.setAddress(medico.getDireccion());
            typeUser.setCui(medico.getCui());
            typeUser.setPhone(medico.getTelefono());
            typeUser.setEmail(medico.getEmail());
            typeUser.setDate(Date.valueOf(medico.getFecha_nacimiento()));
            typeUser.setSaldo(new BigDecimal(medico.getSaldo()));
            typeUser.setType(State.Doctor.name());
            createUser1.createUser(typeUser);
            createUser1.informationComplet(typeUser);
            //horario pendiente
            for (String h : medico.getHorarios()) {
                String[] partes = h.split("-");
                for (String parte : partes) {
                    System.out.println(parte);
                }
            }
            for (EspecialidadPrecio especialidad : medico.getEspecialidades()) {
                CompleteInformation completeInformation = new CompleteInformation();
                completeInformation.setId_user(medico.getId());
                completeInformation.setId_type(especialidad.getId());
                completeInformation.setCost(new BigDecimal(especialidad.getPrecio()));
                CreateIformationDoctor createIformationDoctor = new CreateIformationDoctor();
                createIformationDoctor.create(completeInformation);
            }
        }

        for (Laboratorio lab : data.getLaboratorios()) {
            CreateUser createUser13 = new CreateUser();
            TypeUser typeUserr = new TypeUser();
            typeUserr.setId(lab.getId());
            typeUserr.setName(lab.getNombre());
            typeUserr.setUserName(lab.getUsername());
            typeUserr.setPassword( encriptar.hashPassword(lab.getPassword()));
            typeUserr.setAddress(lab.getDireccion());
            typeUserr.setCui(lab.getCui());
            typeUserr.setPhone(lab.getTelefono());
            typeUserr.setEmail(lab.getEmail());
            typeUserr.setDate(Date.valueOf(lab.getFecha_fundacion()));
            typeUserr.setSaldo(new BigDecimal(lab.getSaldo()));
            typeUserr.setType(State.Laboratorio.name());
            createUser13.createUser(typeUserr);
            createUser13.informationComplet(typeUserr);

            for (ExamenPrecio especialidad : lab.getExamenes()) {
                CompleteInformation completeInformation = new CompleteInformation();
                completeInformation.setId_user(lab.getId());
                completeInformation.setId_type(especialidad.getId());
                completeInformation.setCost(new BigDecimal(especialidad.getPrecio()));
                CreateIformationLab createIformationDoctor = new CreateIformationLab();
                createIformationDoctor.create(completeInformation);
            }

        }

        for (Paciente paciente : data.getPacientes()) {
            CreateUser createUser12 = new CreateUser();
            TypeUser typeUserr = new TypeUser();
            typeUserr.setId(paciente.getId());
            typeUserr.setName(paciente.getNombre());
            typeUserr.setUserName(paciente.getUsername());
            typeUserr.setPassword( encriptar.hashPassword(paciente.getPassword()));
            typeUserr.setAddress(paciente.getDireccion());
            typeUserr.setCui(paciente.getCui());
            typeUserr.setPhone(paciente.getTelefono());
            typeUserr.setEmail(paciente.getEmail());
            typeUserr.setDate(Date.valueOf(paciente.getFecha_nacimiento()));
            typeUserr.setSaldo(new BigDecimal(paciente.getSaldo()));
            typeUserr.setType(State.Paciente.name());
            createUser12.createUser(typeUserr);
            createUser12.informationComplet(typeUserr);
        }

        for (Consulta consulta : data.getConsultas()) {
            Consultation consultation = new Consultation();
            consultation.setId(consulta.getId());
            consultation.setIdPatient(consulta.getPaciente());
            consultation.setDoctor(consulta.getMedico());
            consultation.setSpecialty(consulta.getEspecialidad());
            consultation.setPorcentage(consulta.getPorcentaje_aplicacion());
            consultation.setDataStart(Date.valueOf(consulta.getFecha_creacion()));
            consultation.setDataEnd(Date.valueOf(consulta.getFecha_agendada()));
            consultation.setPrecio(new BigDecimal(consulta.getPrecio()));
            consultation.setInformation(consulta.getInforme_finalizacion());
            consultation.setState(consulta.getEstado());
            CreateConsultation createConsultation = new CreateConsultation();
            createConsultation.create(consultation);
            for (Id id : consulta.getExamenes_solicitados()) {
                CreateExmenesConsulta createExmenesConsulta = new CreateExmenesConsulta();
                createExmenesConsulta.create(consulta.getId(), id.getId());
            }
        }

        for (SolicitudExamen solicitudExamen : data.getSolicitudes()) {
            Solicitud solicitud = new Solicitud();
            solicitudExamen.setPorcentaje_aplicacion(solicitudExamen.getPorcentaje_aplicacion());
             solicitud.create(solicitudExamen);
            for (ExamenPrecio examenPrecio : solicitudExamen.getExamenes()) {
                Exam exam = new Exam();
                exam.setId(examenPrecio.getId());
                exam.setCost(BigDecimal.valueOf(examenPrecio.getPrecio()));
                CreateEx createEx = new CreateEx();
                createEx.create(exam, solicitudExamen.getId());
            }
        }

    }
}
