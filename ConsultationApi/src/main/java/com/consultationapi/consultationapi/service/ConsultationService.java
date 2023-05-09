package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.consultation.CreateConsultation;
import com.consultationapi.consultationapi.data.consultation.ReadConsultation;
import com.consultationapi.consultationapi.data.consultation.UpdateConsultation;
import com.consultationapi.consultationapi.data.porcentage.ReadPercentage;
import com.consultationapi.consultationapi.data.user.UpdataUser;
import com.consultationapi.consultationapi.model.Recharge.Recharge;
import com.consultationapi.consultationapi.model.consultation.Consultation;
import com.consultationapi.consultationapi.model.percentage.Percentage;
import com.consultationapi.consultationapi.state.State;

import java.math.BigDecimal;

public class ConsultationService {
    private CreateConsultation createConsultation;
    private ReadConsultation readConsultation;
    private UpdateConsultation updateConsultation;
    private ReadPercentage readPercentage;
    private double porcentage;
    public ConsultationService (){
        this.createConsultation= new CreateConsultation();
        this.readConsultation= new ReadConsultation();
        this.updateConsultation= new UpdateConsultation();
        this.readPercentage = new ReadPercentage();
    }
    public void Cread(Consultation consul){
        Percentage percentage1 = new Percentage();
        percentage1=readPercentage.read();
        this.porcentage = (double) (percentage1.getPorcentage())/100;
        consul.setId(0);
        consul.setPorcentage(porcentage);
        consul.setState(State.AGENDADA.name());
        createConsultation.create(consul);
        pago(consul);
    }

    public void pago(Consultation consulta){
        Recharge recharge = new Recharge();
        RechargeService rechargeService= new RechargeService();
        double porcentajeAdmin =   consulta.getPrecio().doubleValue()  *this.porcentage;
        double porcentajeDoctor= consulta.getPrecio().doubleValue()-porcentajeAdmin;
        //cargo al admin
        recharge.setMonto(new BigDecimal( porcentajeAdmin));
        recharge.setIdUser(8);
        rechargeService.rechargePatien(recharge);
        // carga al doctor
        recharge.setMonto(new BigDecimal( porcentajeDoctor));
        recharge.setIdUser(consulta.getDoctor());
        rechargeService.rechargePatien(recharge);
        //descuento al
        UpdataUser updataUser= new UpdataUser();
        updataUser.discount(consulta.getIdPatient(),consulta.getPrecio());
    }
}
