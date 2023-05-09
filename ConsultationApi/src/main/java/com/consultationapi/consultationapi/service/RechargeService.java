package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.recharge.CreateRecharge;
import com.consultationapi.consultationapi.data.user.UpdataUser;
import com.consultationapi.consultationapi.model.Recharge.Recharge;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RechargeService {
    private CreateRecharge createRecharge;
    private UpdataUser updataUser;

    public RechargeService() {
        this.createRecharge = new CreateRecharge();
        this.updataUser= new UpdataUser();
    }
    public void rechargePatien(Recharge recharge) {
        LocalDate fechaActual = LocalDate.now();
        System.out.println(recharge.getIdUser());
        recharge.setDate(Date.from(fechaActual.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        updataUser.recharge(recharge.getIdUser(),recharge.getMonto());
        createRecharge.create(recharge);
    }
}




