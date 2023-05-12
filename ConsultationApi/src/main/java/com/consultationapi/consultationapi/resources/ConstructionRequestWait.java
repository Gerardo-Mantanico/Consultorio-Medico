package com.consultationapi.consultationapi.resources;


import com.consultationapi.consultationapi.data.requestWait.ReadRequestWait;
import com.consultationapi.consultationapi.model.lab.requestWait.ExamWait;
import com.consultationapi.consultationapi.model.lab.requestWait.RequestWait;
import com.consultationapi.consultationapi.state.State;

import java.util.ArrayList;

public class ConstructionRequestWait {
    private ReadRequestWait readRequestWait;

    public ConstructionRequestWait(){
        this.readRequestWait= new ReadRequestWait();
    }
    public ArrayList<RequestWait> costruction(int id){
        ArrayList<RequestWait> list = new ArrayList<>();
        for(RequestWait request: readRequestWait.searchRequest(String.valueOf(id))){
            System.out.println("------"+request.getName());
                request.setExam(readRequestWait.searchExam(request.getIdRequest()));
                System.out.println(request.getState());
                if(request.getState().equals(State.PENDIENTE.name())){
                    list.add(request);
                }
        }
        return list;
    }
}
