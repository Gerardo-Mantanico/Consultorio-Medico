package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.CreateRequestExam.CreateEx;
import com.consultationapi.consultationapi.data.CreateRequestExam.CreateRequestExam;
import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.porcentage.ReadPercentage;
import com.consultationapi.consultationapi.data.searchId.SearchId;
import com.consultationapi.consultationapi.data.user.UpdataUser;
import com.consultationapi.consultationapi.model.Recharge.Recharge;
import com.consultationapi.consultationapi.model.patient.Exam;
import com.consultationapi.consultationapi.model.patient.RequestEx;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

public class CreateRequestService extends ConnectionAttributes {
    private CreateRequestExam createRequestExam;
    private ReadPercentage readPercentage;
    private CreateEx creatEx;
    private SearchId searchId;
    private  double total;
    public CreateRequestService(){
        this.createRequestExam=new CreateRequestExam();
        this.total=0;
        this.readPercentage= new ReadPercentage();
        this.creatEx= new CreateEx();
        this.searchId= new SearchId();
    }

    public void create(RequestEx requestEx) {
        pago(requestEx);
        createRequestExam.create(requestEx, readPercentage.read().getPorcentage());
        createlist(requestEx);
    }
    private void pago(RequestEx requestEx){
        Recharge recharge = new Recharge();
        RechargeService rechargeService= new RechargeService();
        for(Exam exam: requestEx.getLisExam()){
            System.out.println("----"+exam.getId() +"   "+exam.getCost());
            total=exam.getCost().doubleValue()+total;
        }
        BigDecimal numero1 = new BigDecimal(readPercentage.read().getPorcentage());
        BigDecimal porcentaje = new BigDecimal("100");
        BigDecimal resultado = numero1.divide(porcentaje, 5, BigDecimal.ROUND_HALF_UP);

        double porcentajeAdmin  =total*resultado.doubleValue();
        double porcentajeLab= total-porcentajeAdmin;
        //cargo al admin
        recharge.setMonto(new BigDecimal( porcentajeAdmin));
        //id del admin
        recharge.setIdUser(8);
        rechargeService.rechargePatien(recharge);

        // carga al lab
        recharge.setMonto(new BigDecimal( porcentajeLab));
        recharge.setIdUser(requestEx.getIdLab());
        rechargeService.rechargePatien(recharge);

        //descuento al
        UpdataUser updataUser= new UpdataUser();
        updataUser.discount(requestEx.getIdPaciente(),new BigDecimal(total));
    }

    private void createlist(RequestEx requestEx){
        for(Exam exam: requestEx.getLisExam()){
            creatEx.create(exam, searchId.IdMax("solicitud_examenes"));
        }
    }


}
