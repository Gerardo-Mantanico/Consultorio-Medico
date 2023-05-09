package com.consultationapi.consultationapi.resources;


import com.consultationapi.consultationapi.data.requestWait.ReadRequestWait;
import com.consultationapi.consultationapi.model.lab.requestWait.ExamWait;
import com.consultationapi.consultationapi.model.lab.requestWait.RequestWait;

import java.util.ArrayList;

public class ConstructionRequestWait {
    private ReadRequestWait readRequestWait;

    public ConstructionRequestWait(){
        this.readRequestWait= new ReadRequestWait();
    }
    public ArrayList<RequestWait> costruction(String id){
        ArrayList<RequestWait> list = new ArrayList<>();
        for(RequestWait request: readRequestWait.searchRequest(id)){
            System.out.println("------"+request.getName());
                request.setExam(readRequestWait.searchExam(request.getIdRequest()));
            list.add(request);
        }
        return list;
    }
}
